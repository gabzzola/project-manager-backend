package com.gabzzola.projectmanager.mapper;

import com.gabzzola.projectmanager.dto.project.ProjectCreateDTO;
import com.gabzzola.projectmanager.dto.project.ProjectResponseDTO;
import com.gabzzola.projectmanager.dto.project.ProjectUpdateDTO;
import com.gabzzola.projectmanager.model.ProjectModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponseDTO toResponseDTO(ProjectModel model);

    ProjectModel toModel(ProjectCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "category", ignore = true)
    void updateFromDTO(ProjectUpdateDTO dto, @MappingTarget ProjectModel project);
}
