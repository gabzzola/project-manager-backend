package com.gabzzola.projectmanager.repository;

import com.gabzzola.projectmanager.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {

    List<ProjectModel> findByDeletedFalse();
    Optional<ProjectModel> findByIdAndDeletedFalse(Long id);

    @Modifying
    @Query("UPDATE ProjectModel p SET p.deleted = true WHERE p.id = :id")
    void softDelete(@Param("id") Long id);
}
