package com.witnesses.web.service;

import com.witnesses.web.dto.EngineDto;

import java.util.List;

public interface EngineService {
    void signIn(EngineDto engineDTO);

    EngineDto update(String id, EngineDto engineDTO);

    EngineDto engine(String id);

    List<EngineDto> engineList();
}
