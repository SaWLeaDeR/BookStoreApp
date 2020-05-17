package com.book.book.controller.endpoint;

public class BookEndpoint {

    public BookEndpoint() {
    }

    public static final String BOOKS = "/list";
    public static final String BOOK = "/{id}";
    public static final String BOOK_CATEGORY = "category";
    public static final String BOOK_CREATE = "/create";
    public static final String BOOK_UPDATE = "/update/{id}";
    public static final String BOOK_CATEGORY_UPDATE = "/update/category";
    public static final String BOOK_DELETE = "/delete/{id}";
    public static final String BOOK_CATEGORY_DELETE = "/delete/category";
}
