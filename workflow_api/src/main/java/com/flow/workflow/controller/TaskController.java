package com.flow.workflow.controller;

import com.flow.workflow.api.TaskService;
import com.flow.workflow.entity.Task;
import com.flow.workflow.request.dto.CreateTaskRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

//    @PostMapping("/save")
//    ResponseEntity<String> saveTask(CreateTaskRequestDTO requestDTO);
//
//    @PutMapping("/update")
//    ResponseEntity<String> updateTask();

    @PostMapping("/createTask")
    public ResponseEntity<Task> createTask(@Valid @RequestBody CreateTaskRequestDTO requestDTO){
        String createUser = "system_admin";
        Task createdTask = taskService.createTask(requestDTO,createUser);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }
}
