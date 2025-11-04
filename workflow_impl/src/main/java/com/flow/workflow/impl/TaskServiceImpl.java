package com.flow.workflow.impl;

import com.flow.workflow.api.TaskService;
import com.flow.workflow.entity.Task;
import com.flow.workflow.repository.TaskRepository;
import com.flow.workflow.request.dto.CreateTaskRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public Task createTask(CreateTaskRequestDTO requestDTO, String user){
        if(taskRepository.existsByTaskName(requestDTO.taskName())){
            throw new IllegalArgumentException("Task name: " + requestDTO.taskName() + " already exists");
        }
        Task entity = mapRequestToEntity(requestDTO, user);

        return taskRepository.save(entity);
    }

    private Task mapRequestToEntity(CreateTaskRequestDTO requestDTO, String user){
        Task entity = new Task();
        entity.setTaskName(requestDTO.taskName());
        entity.setTaskType(requestDTO.taskType());
        entity.setParameters(requestDTO.parameters());
        entity.setTimeoutSeconds(requestDTO.timeoutSeconds());

        entity.setCreatedBy(user);
        entity.setUpdatedBy(user);

        return entity;
    }
}
