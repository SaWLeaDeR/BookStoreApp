package com.bookstoreapp.bookstoreapp.domain.converter.bookstore;

import com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.model.dto.BookStoreFoundationDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookStoreDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.CollectionUtils;

public class BookStoreFoundationDtoConverter {

    public static BookStoreFoundationDtoConverter INSTANCE = new BookStoreFoundationDtoConverter();

    private BookStoreFoundationDtoConverter(){
    }

    public static BookStoreFoundationDtoConverter getInstance() {
        return INSTANCE;
    }

    public List<BookStoreFoundationDto> convert(List<BookStoreDto> bookStores){
        if (CollectionUtils.isEmpty(bookStores)) {
            return null;
        }
        List<BookStoreFoundationDto> bookStoreFoundations= new ArrayList<>();

        for (BookStoreDto bookStore :  bookStores) {
            bookStoreFoundations.add(convertSingleBookStore(bookStore));
        }
        return bookStoreFoundations;
    }

    public BookStoreFoundationDto convertSingleBookStore(BookStoreDto bookStore) {
        if (bookStore == null) {
            return null;
        }

        BookStoreFoundationDto bookStoreFoundation = new BookStoreFoundationDto();
        bookStoreFoundation.setName(bookStore.getBookStoreName());
        bookStoreFoundation.setAdditionalPrice(bookStore.getAdditionalPrice());
        return bookStoreFoundation;
    }

}
