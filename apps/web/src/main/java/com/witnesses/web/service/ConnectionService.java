package com.witnesses.web.service;

import com.witnesses.web.dto.ConnectionDto;

import java.util.List;

public interface ConnectionService {
    ConnectionDto create(ConnectionDto connectionDTO);

    void delete(String id);

    ConnectionDto update(String id, ConnectionDto connection);

    ConnectionDto connection(String id);

    List<ConnectionDto> connectionList();
}
