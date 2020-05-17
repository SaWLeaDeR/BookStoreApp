package com.book.book.repository;

import com.book.book.model.entity.BookEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

    @Override
    List<BookEntity> findAll();

    List<BookEntity> findByCategory(String name);

}
