package com.witnesses.web.service;

import com.witnesses.web.dto.WorkSpaceDto;

import java.util.List;

public interface WorkSpaceService {
    /**
     * Create a new workspace
     */
    WorkSpaceDto create(WorkSpaceDto workSpaceDto);

    /**
     * Delete a workspace
     */
    void delete(String id);

    /**
     * Update a workspace
     */
    WorkSpaceDto update(String id, WorkSpaceDto workSpaceDto);

    /**
     * get a workspace
     */
    WorkSpaceDto workspace(String id);

    /**
     * Get a list of workspaces
     */
    List<WorkSpaceDto> workspaceList();
}
