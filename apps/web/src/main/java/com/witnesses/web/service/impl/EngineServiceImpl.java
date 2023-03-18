package com.witnesses.web.service.impl;

import com.witnesses.web.dto.EngineDto;
import com.witnesses.web.service.EngineService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EngineServiceImpl implements EngineService {
    @Override
    public void signIn(EngineDto engineDTO) {

    }

    @Override
    public EngineDto update(String id, EngineDto engineDTO) {
        return null;
    }

    @Override
    public EngineDto engine(String id) {
        return null;
    }

    @Override
    public List<EngineDto> engineList() {
        return null;
    }
}
