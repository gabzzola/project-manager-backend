package com.gabzzola.projectmanager.mapper;

import com.gabzzola.projectmanager.dto.category.CategoryRequestDTO;
import com.gabzzola.projectmanager.dto.category.CategoryResponseDTO;
import com.gabzzola.projectmanager.model.CategoryModel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponseDTO toResponseDTO(CategoryModel model);

    CategoryModel toModel(CategoryRequestDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDTO(CategoryRequestDTO dto, @MappingTarget CategoryModel category);
}
