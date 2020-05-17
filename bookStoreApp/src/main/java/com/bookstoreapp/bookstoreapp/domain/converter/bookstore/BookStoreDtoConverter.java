package com.bookstoreapp.bookstoreapp.domain.converter.bookstore;

import com.bookstoreapp.bookstoreapp.delegate.bookstorefoundation.model.dto.BookStoreFoundationDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookStoreDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.CollectionUtils;

public class BookStoreDtoConverter {

    public static BookStoreDtoConverter INSTANCE = new BookStoreDtoConverter();

    private BookStoreDtoConverter(){
    }

    public static BookStoreDtoConverter getInstance() {
        return INSTANCE;
    }

    public List<BookStoreDto> convert(List<BookStoreFoundationDto> bookStoreFoundations){
        if (CollectionUtils.isEmpty(bookStoreFoundations)) {
            return null;
        }
        List<BookStoreDto> bookStores= new ArrayList<>();

        for (BookStoreFoundationDto bookStoreFoundation :  bookStoreFoundations) {
            bookStores.add(convertSingleBookStore(bookStoreFoundation));
        }
        return bookStores;
    }

    public BookStoreDto convertSingleBookStore(BookStoreFoundationDto bookStoreFoundation) {
        if (bookStoreFoundation == null) {
            return null;
        }

        BookStoreDto bookStore = new BookStoreDto();
        bookStore.setBookStoreName(bookStoreFoundation.getName());
        bookStore.setAdditionalPrice(bookStoreFoundation.getAdditionalPrice());
        return bookStore;
    }

}
