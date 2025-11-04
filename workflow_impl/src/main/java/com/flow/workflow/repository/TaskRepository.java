package com.flow.workflow.repository;

import com.flow.workflow.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    boolean existsByTaskName(@RequestParam String taskName);
}
