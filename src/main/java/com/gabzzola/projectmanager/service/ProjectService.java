package com.gabzzola.projectmanager.service;

import com.gabzzola.projectmanager.dto.project.ProjectCreateDTO;
import com.gabzzola.projectmanager.dto.project.ProjectResponseDTO;
import com.gabzzola.projectmanager.dto.project.ProjectUpdateDTO;
import com.gabzzola.projectmanager.exception.NotFoundException;
import com.gabzzola.projectmanager.mapper.ProjectMapper;
import com.gabzzola.projectmanager.model.ProjectModel;
import com.gabzzola.projectmanager.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    public ProjectResponseDTO create(ProjectCreateDTO dto) {
        ProjectModel project = projectMapper.toModel(dto);
        ProjectModel savedProject = projectRepository.save(project);
        return projectMapper.toResponseDTO(savedProject);
    }

    public List<ProjectResponseDTO> findAll() {
        return projectRepository.findByDeletedFalse().stream()
                .map(projectMapper::toResponseDTO)
                .toList();
    }

    public ProjectResponseDTO findById(Long id) {
        ProjectModel project = getProjectEntityById(id);
        return projectMapper.toResponseDTO(project);
    }

    public ProjectResponseDTO update(Long id, ProjectUpdateDTO dto) {
        ProjectModel project = getProjectEntityById(id);

        projectMapper.updateFromDTO(dto, project);

        ProjectModel updatedProject = projectRepository.save(project);
        return projectMapper.toResponseDTO(updatedProject);
    }

    @Transactional
    public void delete(Long id) {
        projectRepository.softDelete(id);
    }

    private ProjectModel getProjectEntityById(Long id) {
        return projectRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Projeto não encontrado"));
    }
}
