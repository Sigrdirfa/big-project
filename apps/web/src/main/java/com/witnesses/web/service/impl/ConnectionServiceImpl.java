package com.witnesses.web.service.impl;

import com.witnesses.web.dto.ConnectionDto;
import com.witnesses.web.service.ConnectionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConnectionServiceImpl implements ConnectionService {
    @Override
    public ConnectionDto create(ConnectionDto connectionDTO) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ConnectionDto update(String id, ConnectionDto connection) {
        return null;
    }

    @Override
    public ConnectionDto connection(String id) {
        return null;
    }

    @Override
    public List<ConnectionDto> connectionList() {
        return null;
    }
}
