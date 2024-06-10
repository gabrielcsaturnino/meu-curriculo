package org.example.meucurriculo.repository;

import org.example.meucurriculo.models.Project;

public interface ProjectRepository {
     void saveProject(Project project);
     Project getProject(String id);
}
