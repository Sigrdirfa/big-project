package com.witnesses.web.service;

import com.witnesses.web.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto create(TaskDto taskDTO);

    void delete(String id);

    TaskDto update(String id, TaskDto taskDTO);

    TaskDto task(String id);

    List<TaskDto> taskList();
}
