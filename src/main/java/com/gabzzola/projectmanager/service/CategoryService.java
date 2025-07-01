package com.gabzzola.projectmanager.service;

import com.gabzzola.projectmanager.dto.category.CategoryRequestDTO;
import com.gabzzola.projectmanager.dto.category.CategoryResponseDTO;
import com.gabzzola.projectmanager.exception.NotFoundException;
import com.gabzzola.projectmanager.mapper.CategoryMapper;
import com.gabzzola.projectmanager.model.CategoryModel;
import com.gabzzola.projectmanager.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryResponseDTO create(CategoryRequestDTO dto) {
        CategoryModel category = categoryMapper.toModel(dto);
        CategoryModel savedCategory = categoryRepository.save(category);
        return categoryMapper.toResponseDTO(savedCategory);
    }

    public List<CategoryResponseDTO> findAll() {
        return categoryRepository.findByDeletedFalse().stream()
                .map(categoryMapper::toResponseDTO)
                .toList();
    }

    public CategoryResponseDTO findById(Long id) {
        CategoryModel category = getCategoryEntityById(id);
        return categoryMapper.toResponseDTO(category);
    }

    public CategoryResponseDTO update(Long id, CategoryRequestDTO dto) {
        CategoryModel category = getCategoryEntityById(id);

        categoryMapper.updateFromDTO(dto, category);

        CategoryModel updatedCategory = categoryRepository.save(category);
        return categoryMapper.toResponseDTO(updatedCategory);
    }

    @Transactional
    public void delete(Long id) {
        categoryRepository.softDelete(id);
    }

    public CategoryModel getCategoryEntityById(Long id) {
        return categoryRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
    }
}
