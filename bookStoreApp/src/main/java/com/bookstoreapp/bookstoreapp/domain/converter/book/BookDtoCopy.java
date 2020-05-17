package com.bookstoreapp.bookstoreapp.domain.converter.book;

import com.bookstoreapp.bookstoreapp.domain.model.dto.BookDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.CollectionUtils;

public class BookDtoCopy {

    public static BookDtoCopy INSTANCE = new BookDtoCopy();

    private BookDtoCopy() {
    }

    public static BookDtoCopy getInstance() {
        return INSTANCE;
    }

    public List<BookDto> copy(List<BookDto> bookList) {
        if (CollectionUtils.isEmpty(bookList)) {
            return null;
        }
        List<BookDto> books = new ArrayList<>();

        for (BookDto book : bookList) {
            books.add(copySingleBook(book));
        }
        return books;
    }

    public BookDto copySingleBook(BookDto bookFoundation) {
        if (bookFoundation == null) {
            return null;
        }
        BookDto book = new BookDto();
        book.setBookName(bookFoundation.getBookName());
        book.setCategoryName(bookFoundation.getCategoryName());
        book.setPrice(bookFoundation.getPrice());
        return book;
    }

}
