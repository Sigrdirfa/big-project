package com.witnesses.web.controller;

import com.witnesses.web.dto.TaskDto;
import com.witnesses.web.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDTO) {
        return ResponseEntity.ok(taskService.create(taskDTO));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<TaskDto> updateTask(@PathVariable String id, @RequestBody TaskDto taskDTO) {
        return ResponseEntity.ok(taskService.update(id, taskDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> task(@PathVariable String id) {
        return ResponseEntity.ok(taskService.task(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<TaskDto>> taskList() {
        return ResponseEntity.ok(taskService.taskList());
    }
}
