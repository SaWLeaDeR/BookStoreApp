package com.bookstore.bookstore.domain.controller.endpoint;

public class BookStoreEndpoint {

    public BookStoreEndpoint() {
    }
    public static final String GET_ALL = "/list";
    public static final String GET_BOOK_STORE = "/{id}";
    public static final String GET_BOOK_STORE_BY_NAME = "/book-store-name";
    public static final String BOOK_STORE_CREATE = "/create";
    public static final String BOOK_STORE_UPDATE = "/update/{id}";
    public static final String BOOK_STORE_DELETE = "/delete/{id}";

}
