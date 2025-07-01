package com.gabzzola.projectmanager.repository;

import com.gabzzola.projectmanager.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

    List<CategoryModel> findByDeletedFalse();
    Optional<CategoryModel> findByIdAndDeletedFalse(Long id);

    @Modifying
    @Query("UPDATE CategoryModel c SET c.deleted = true WHERE c.id = :id")
    void softDelete(@Param("id") Long id);
}
