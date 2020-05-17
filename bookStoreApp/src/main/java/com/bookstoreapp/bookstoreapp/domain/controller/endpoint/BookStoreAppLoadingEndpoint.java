package com.bookstoreapp.bookstoreapp.domain.controller.endpoint;

public class BookStoreAppLoadingEndpoint {

    public BookStoreAppLoadingEndpoint() {
    }

    public static final String GET_ALL_BOOKS = "/list/book";
    public static final String GET_ALL_CATEGORIES = "/list/category";
    public static final String GET_ALL_BOOK_STORES = "/list/book-store";
    public static final String GET_BOOK = "/book/{id}";
    public static final String GET_CATEGORY = "/category/{id}";
    public static final String GET_CATEGORY_BY_NAME = "/category/name";
    public static final String GET_BOOK_STORE = "/book-store/{id}";
    public static final String GET_ALL_BOOKS_BY_CATEGORY = "/list/book/category";

}
