package com.foundation.category.domain.repository;

import com.foundation.category.domain.model.entity.CategoryEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

    @Override
    List<CategoryEntity> findAll();

    CategoryEntity findByName(String name);

}
