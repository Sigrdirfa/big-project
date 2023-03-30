package com.witnesses.web.service;

import com.witnesses.web.dto.TaskDto;

import java.util.List;

public interface TaskService {
    /**
     * Create a new task
     */
    TaskDto create(TaskDto taskDTO);

    /**
     * Delete a task
     */
    void delete(String id);

    /**
     * Update a task
     */
    TaskDto update(String id, TaskDto taskDTO);

    /**
     * Get a task
     */
    TaskDto task(String id);

    /**
     * Get a list of tasks
     */
    List<TaskDto> taskList();
}
