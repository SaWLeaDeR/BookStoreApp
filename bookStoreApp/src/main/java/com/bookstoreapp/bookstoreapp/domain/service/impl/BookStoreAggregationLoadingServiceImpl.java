package com.bookstoreapp.bookstoreapp.domain.service.impl;

import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.service.BookFoundationLoadingService;
import com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.service.BookStoreFoundationLoadingService;
import com.bookstoreapp.bookstoreapp.delegate.categoryfoundation.service.CategoryFoundationService;
import com.bookstoreapp.bookstoreapp.domain.converter.book.BookDtoConverter;
import com.bookstoreapp.bookstoreapp.domain.converter.book.BookDtoCopy;
import com.bookstoreapp.bookstoreapp.domain.converter.bookstore.BookStoreDtoConverter;
import com.bookstoreapp.bookstoreapp.domain.converter.category.CategoryDtoConverter;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookStoreDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.CategoryDto;
import com.bookstoreapp.bookstoreapp.domain.service.BookStoreAggregationLoadingService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class BookStoreAggregationLoadingServiceImpl implements BookStoreAggregationLoadingService {

    private final BookFoundationLoadingService bookFoundationLoadingService;
    private final CategoryFoundationService categoryFoundationService;
    private final BookStoreFoundationLoadingService bookStoreFoundationLoadingService;

    public BookStoreAggregationLoadingServiceImpl(
        BookFoundationLoadingService bookFoundationLoadingService,
        CategoryFoundationService categoryFoundationService,
        BookStoreFoundationLoadingService bookStoreFoundationLoadingService) {
        this.bookFoundationLoadingService = bookFoundationLoadingService;
        this.categoryFoundationService = categoryFoundationService;
        this.bookStoreFoundationLoadingService = bookStoreFoundationLoadingService;
    }


    @Override
    public List<BookStoreDto> getAll() {
        List<BookDto> allBooks = BookDtoConverter.getInstance().convert(bookFoundationLoadingService.getAllBooks());
        List<BookStoreDto> allBookStores = BookStoreDtoConverter.getInstance().convert(bookStoreFoundationLoadingService.getAllBookStores());
        fillBookInfo(allBooks, allBookStores);
        return allBookStores;
    }

    @Override
    public List<BookDto> getAllBooks() {
        return BookDtoConverter.getInstance().convert(bookFoundationLoadingService.getAllBooks());
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return CategoryDtoConverter.getInstance().convert(categoryFoundationService.getAllCategories());
    }

    @Override
    public List<BookStoreDto> getAllBookStores() {
        return BookStoreDtoConverter.getInstance().convert(bookStoreFoundationLoadingService.getAllBookStores());
    }

    @Override
    public BookDto getBook(Long id) {
        return BookDtoConverter.getInstance().convertSingleBook(bookFoundationLoadingService.getBook(id));
    }

    @Override
    public CategoryDto getCategory(Long id) {
        return CategoryDtoConverter.getInstance().convertSingleCategory(categoryFoundationService.getCategory(id));
    }

    @Override
    public CategoryDto getCategoryByName(String categoryName) {
        return CategoryDtoConverter.getInstance().convertSingleCategory(categoryFoundationService.getCategoryByName(categoryName));
    }

    @Override
    public BookStoreDto getBookStore(Long id) {
        return BookStoreDtoConverter.getInstance().convertSingleBookStore(bookStoreFoundationLoadingService.getBookStore(id));
    }

    @Override
    public List<BookDto> getBooksByCategoryName(String categoryName) {
        return BookDtoConverter.getInstance().convert(bookFoundationLoadingService.getBookByCategory(categoryName));
    }

    private void fillBookInfo(List<BookDto> allBooks, List<BookStoreDto> allBookStores) {
        if (CollectionUtils.isEmpty(allBookStores)){
            return ;
        }

        for (BookStoreDto bookStore : allBookStores) {
            List<BookDto> books = BookDtoCopy.getInstance().copy(allBooks);
            bookStore.setBooks(books);

            for (BookDto book : bookStore.getBooks()) {
                book.setPrice(book.getPrice().add(bookStore.getAdditionalPrice()));
            }
        }
    }
}
