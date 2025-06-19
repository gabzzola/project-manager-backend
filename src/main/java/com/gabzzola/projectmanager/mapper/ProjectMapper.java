package com.gabzzola.projectmanager.mapper;

import com.gabzzola.projectmanager.dto.project.ProjectCreateDTO;
import com.gabzzola.projectmanager.dto.project.ProjectResponseDTO;
import com.gabzzola.projectmanager.dto.project.ProjectUpdateDTO;
import com.gabzzola.projectmanager.model.ProjectModel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponseDTO toResponseDTO(ProjectModel model);

    ProjectModel toModel(ProjectCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDTO(ProjectUpdateDTO dto, @MappingTarget ProjectModel project);
}
