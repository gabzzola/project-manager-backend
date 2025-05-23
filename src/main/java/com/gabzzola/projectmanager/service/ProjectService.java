package com.gabzzola.projectmanager.service;

import com.gabzzola.projectmanager.dto.ProjectUpdateDTO;
import com.gabzzola.projectmanager.exception.NotFoundException;
import com.gabzzola.projectmanager.model.ProjectModel;
import com.gabzzola.projectmanager.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectModel> findAll() {
        return projectRepository.findAll();
    }

    public ProjectModel findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Projeto não encontrado"));
    }

    public ProjectModel create(ProjectModel project) {
        return projectRepository.save(project);
    }

    public ProjectModel update(Long id, ProjectUpdateDTO dto) {
        ProjectModel existingProject = this.findById(id);

        if (dto.getName() != null) existingProject.setName(dto.getName());
        if (dto.getBudget() != null) existingProject.setBudget(dto.getBudget());

        return projectRepository.save(existingProject);
    }

    public void delete(Long id) {
        ProjectModel project = this.findById(id);
        projectRepository.delete(project);
    }
}
