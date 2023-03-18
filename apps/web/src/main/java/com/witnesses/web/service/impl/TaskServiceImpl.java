package com.witnesses.web.service.impl;

import com.witnesses.web.dto.TaskDto;
import com.witnesses.web.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public TaskDto create(TaskDto taskDTO) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public TaskDto update(String id, TaskDto taskDTO) {
        return null;
    }

    @Override
    public TaskDto task(String id) {
        return null;
    }

    @Override
    public List<TaskDto> taskList() {
        return null;
    }
}
