package com.flow.workflow.api;

import com.flow.workflow.entity.Task;
import com.flow.workflow.request.dto.CreateTaskRequestDTO;

/**
 * Defines the contract for managing Task definitions (create, update, delete).
 */
public interface TaskService {

    /**
     * Creates a new Task definition based on user request.
     * @param requestDTO The DTO containing task details.
     * @param user The user initiating the request.
     * @return The newly created Task entity.
     * @throws IllegalArgumentException if the task name already exists.
     */
    Task createTask(CreateTaskRequestDTO requestDTO, String user);
}
