package com.witnesses.web.service;

import com.witnesses.web.dto.WorkSpaceDto;

import java.util.List;

public interface WorkSpaceService {
    WorkSpaceDto create(WorkSpaceDto workSpaceDto);

    void delete(String id);

    WorkSpaceDto update(String id, WorkSpaceDto workSpaceDto);

    WorkSpaceDto workspace(String id);

    List<WorkSpaceDto> workspaceList();
}
