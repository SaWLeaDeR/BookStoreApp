package com.bookstore.bookstore.domain.repository;

import com.bookstore.bookstore.domain.model.entity.BookStoreEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreRepository extends CrudRepository<BookStoreEntity, Long> {

    @Override
    List<BookStoreEntity> findAll();

    List<BookStoreEntity> findByName(String name);

}
