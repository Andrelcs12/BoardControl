package org.example.boardcontrol.task.repository;

import org.example.boardcontrol.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
