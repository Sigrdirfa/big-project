package com.witnesses.web.service;

import com.witnesses.web.dto.EngineDto;

import java.util.List;

public interface EngineService {
    /**
     * Create a new engine
     */
    void signIn(EngineDto engineDTO);

    /**
     * Update an engine
     */
    EngineDto update(String id, EngineDto engineDTO);

    /**
     * Get an engine
     */
    EngineDto engine(String id);

    /**
     * Get a list of engines
     */
    List<EngineDto> engineList();
}
