package com.bookstoreapp.bookstoreapp.domain.converter.book;

import com.bookstoreapp.bookstoreapp.delegate.bookfoundation.model.dto.BookFoundationDto;
import com.bookstoreapp.bookstoreapp.domain.model.dto.BookDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class BookFoundationDtoConverter {

    public static BookFoundationDtoConverter INSTANCE = new BookFoundationDtoConverter();

    private BookFoundationDtoConverter(){
    }

    public static BookFoundationDtoConverter getInstance() {
        return INSTANCE;
    }

    public List<BookFoundationDto> convert(List<BookDto> books){
        if (CollectionUtils.isEmpty(books)) {
            return null;
        }
        List<BookFoundationDto> bookFoundations = new ArrayList<>();

        for (BookDto book : books) {
            bookFoundations.add(convertSingleBookFoundation(book));
        }
        return bookFoundations;
    }

    public BookFoundationDto convertSingleBookFoundation(BookDto book) {
        BookFoundationDto bookFoundation = new BookFoundationDto();
        bookFoundation.setName(book.getBookName());
        bookFoundation.setCategory(book.getCategoryName());
        bookFoundation.setPrice(book.getPrice());
        return bookFoundation;
    }

}
