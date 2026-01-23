package org.example.boardcontrol.project.repository;

import org.example.boardcontrol.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    public Project findByName(String name);
}
