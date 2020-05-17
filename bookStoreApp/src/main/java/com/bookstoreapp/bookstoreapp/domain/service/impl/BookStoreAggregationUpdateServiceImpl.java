package com.bookstoreapp.bookstoreapp.domain.service.impl;

import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.dto.BookFoundationDto;
import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.request.CategoryDeleteDto;
import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.request.CategoryUpdateDto;
import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.service.BookFoundationLoadingService;
import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.service.BookFoundationUpdateService;
import com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.model.dto.BookStoreFoundationDto;
import com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.service.BookStoreFoundationUpdateService;
import com.bookstoreapp.bookstoreapp.delegate.categoryfoundation.model.dto.CategoryFoundationDto;
import com.bookstoreapp.bookstoreapp.delegate.categoryfoundation.service.CategoryFoundationService;
import com.bookstoreapp.bookstoreapp.domain.converter.book.BookDtoConverter;
import com.bookstoreapp.bookstoreapp.domain.converter.book.BookFoundationDtoConverter;
import com.bookstoreapp.bookstoreapp.domain.converter.bookstore.BookStoreDtoConverter;
import com.bookstoreapp.bookstoreapp.domain.converter.bookstore.BookStoreFoundationDtoConverter;
import com.bookstoreapp.bookstoreapp.domain.converter.category.CategoryDtoConverter;
import com.bookstoreapp.bookstoreapp.domain.converter.category.CategoryFoundationDtoConverter;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookStoreDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.CategoryDto;
import com.bookstoreapp.bookstoreapp.domain.service.BookStoreAggregationUpdateService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class BookStoreAggregationUpdateServiceImpl implements BookStoreAggregationUpdateService {

    private final BookFoundationUpdateService bookFoundationUpdateService;

    private final BookFoundationLoadingService bookFoundationLoadingService;
    private final CategoryFoundationService categoryFoundationService;
    private final BookStoreFoundationUpdateService bookStoreFoundationUpdateService;

    public BookStoreAggregationUpdateServiceImpl(
        BookFoundationUpdateService bookFoundationUpdateService,
        BookFoundationLoadingService bookFoundationLoadingService,
        CategoryFoundationService categoryFoundationService,
        BookStoreFoundationUpdateService bookStoreFoundationUpdateService) {
        this.bookFoundationUpdateService = bookFoundationUpdateService;
        this.bookFoundationLoadingService = bookFoundationLoadingService;
        this.categoryFoundationService = categoryFoundationService;
        this.bookStoreFoundationUpdateService = bookStoreFoundationUpdateService;
    }

    @Override
    public BookDto addBook(BookDto book) {
        final CategoryFoundationDto categoryFoundationDto = checkCategoryByName(book.getCategoryName());
        if (categoryFoundationDto == null){
            createCategory(book.getCategoryName());
        }
        final BookFoundationDto bookFoundation = BookFoundationDtoConverter.getInstance().convertSingleBookFoundation(book);
        final BookFoundationDto bookFoundationDto = bookFoundationUpdateService.addBook(bookFoundation);
        return BookDtoConverter.getInstance().convertSingleBook(bookFoundationDto);
    }

    @Override
    public BookDto updateBook(Long id, BookDto book) {
        final BookFoundationDto oldValue = getBook(id);
        final List<BookFoundationDto> books = getBookListByName(oldValue.getCategory());
        final CategoryFoundationDto categoryFoundationDto = checkCategoryByName(book.getCategoryName());
        if (categoryFoundationDto == null) {
            createCategory(book.getCategoryName());
        }
        BookFoundationDto bookFoundation = BookFoundationDtoConverter.getInstance().convertSingleBookFoundation(book);
        BookFoundationDto bookFoundationDto = bookFoundationUpdateService.updateBook(id, bookFoundation);
        if (books.size() == 1) {
            deleteSingleCategory(oldValue.getCategory());
        }
        return BookDtoConverter.getInstance().convertSingleBook(bookFoundationDto);
    }

    @Override
    public BookDto updateBooks(CategoryUpdateDto categoryUpdate) {
        final CategoryFoundationDto categoryByName = categoryFoundationService.getCategoryByName(categoryUpdate.getNewCategoryName());
        if (categoryByName == null) {
            createCategory(categoryUpdate.getNewCategoryName());
        }
        categoryFoundationService.deleteCategoryByName(categoryUpdate.getOldCategoryName());
        BookFoundationDto bookFoundations = bookFoundationUpdateService.updateBooks(categoryUpdate);
        return BookDtoConverter.getInstance().convertSingleBook(bookFoundations);
    }

    @Override
    public void deleteBook(Long id) {
        final BookFoundationDto book = getBook(id);
        bookFoundationUpdateService.deleteBook(id);
        final List<BookFoundationDto> bookListByName = getBookListByName(book.getCategory());
        if (CollectionUtils.isEmpty(bookListByName)){
            deleteSingleCategory(book.getCategory());
        }
    }

    @Override
    public void deleteBooks(CategoryDeleteDto categoryDelete) {
        bookFoundationUpdateService.deleteBooks(categoryDelete);
    }

    @Override
    public CategoryDto addCategory(CategoryDto category) {
        CategoryFoundationDto categoryFoundation = CategoryFoundationDtoConverter.getInstance().convertSingleCategory(category);
        CategoryFoundationDto categoryFoundationDto = categoryFoundationService.addCategory(categoryFoundation);
        return CategoryDtoConverter.getInstance().convertSingleCategory(categoryFoundationDto);
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto category) {
        final CategoryFoundationDto oldCategory = categoryFoundationService.getCategory(id);
        updateBooksByCategories(oldCategory.getName(), category.getCategoryName());
        CategoryFoundationDto categoryFoundation = CategoryFoundationDtoConverter.getInstance().convertSingleCategory(category);
        CategoryFoundationDto categoryFoundationDto = categoryFoundationService.updateCategory(id, categoryFoundation);
        return CategoryDtoConverter.getInstance().convertSingleCategory(categoryFoundationDto);
    }

    @Override
    public void deleteCategory(Long id) {
        final CategoryFoundationDto category = categoryFoundationService.getCategory(id);
        deleteAllBooksByCategory(category.getName());
        categoryFoundationService.deleteCategory(id);

    }

    private void deleteAllBooksByCategory(String name) {
        CategoryDeleteDto categoryDelete = new CategoryDeleteDto();
        categoryDelete.setCategoryName(name);
        bookFoundationUpdateService.deleteBooks(categoryDelete);
    }

    @Override
    public BookStoreDto addBookStore(BookStoreDto bookStore) {
        BookStoreFoundationDto bookStoreFoundation = BookStoreFoundationDtoConverter.getInstance().convertSingleBookStore(bookStore);
        BookStoreFoundationDto bookStoreFoundationDto = bookStoreFoundationUpdateService.addBookStore(bookStoreFoundation);
        return BookStoreDtoConverter.getInstance().convertSingleBookStore(bookStoreFoundationDto);
    }

    @Override
    public BookStoreDto updateBookStore(Long id, BookStoreDto bookStore) {
        BookStoreFoundationDto bookStoreFoundation = BookStoreFoundationDtoConverter.getInstance().convertSingleBookStore(bookStore);
        BookStoreFoundationDto bookStoreFoundationDto = bookStoreFoundationUpdateService.updateBookStore(id, bookStoreFoundation);
        return BookStoreDtoConverter.getInstance().convertSingleBookStore(bookStoreFoundationDto);
    }

    @Override
    public void deleteBookStore(Long id) {
        bookStoreFoundationUpdateService.deleteBookStore(id);
    }

    private void createCategory(String categoryName) {
        CategoryFoundationDto categoryDto = new CategoryFoundationDto();
        categoryDto.setName(categoryName);
        categoryFoundationService.addCategory(categoryDto);
    }

    private CategoryFoundationDto checkCategoryByName(String categoryName) {
        return categoryFoundationService.getCategoryByName(categoryName);
    }

    private BookFoundationDto getBook(Long id) {
        return bookFoundationLoadingService.getBook(id);
    }

    private List<BookFoundationDto> getBookListByName(String categoryName) {
        return bookFoundationLoadingService.getBookByCategory(categoryName);
    }

    private void deleteSingleCategory(String category) {
        categoryFoundationService.deleteCategoryByName(category);
    }

    private void updateBooksByCategories(String oldName, String newName) {
        CategoryUpdateDto categoryUpdate = new CategoryUpdateDto();
        categoryUpdate.setOldCategoryName(oldName);
        categoryUpdate.setNewCategoryName(newName);
        bookFoundationUpdateService.updateBooks(categoryUpdate);
    }
}
