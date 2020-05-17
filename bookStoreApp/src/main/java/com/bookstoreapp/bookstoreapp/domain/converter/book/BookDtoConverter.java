package com.bookstoreapp.bookstoreapp.domain.converter.book;

import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.dto.BookFoundationDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.CollectionUtils;

public class BookDtoConverter {

    public static BookDtoConverter INSTANCE = new BookDtoConverter();

    private BookDtoConverter(){
    }

    public static BookDtoConverter getInstance() {
        return INSTANCE;
    }

    public List<BookDto> convert(List<BookFoundationDto> bookFoundations){
        if (CollectionUtils.isEmpty(bookFoundations)) {
            return null;
        }
        List<BookDto> books = new ArrayList<>();

        for (BookFoundationDto bookFoundation :  bookFoundations) {
            books.add(convertSingleBook(bookFoundation));
        }
        return books;
    }

    public BookDto convertSingleBook(BookFoundationDto bookFoundation) {
        if (bookFoundation == null) {
            return null;
        }
        BookDto book = new BookDto();
        book.setBookName(bookFoundation.getName());
        book.setCategoryName(bookFoundation.getCategory());
        book.setPrice(bookFoundation.getPrice());
        return book;
    }

}
