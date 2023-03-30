package com.witnesses.web.service;

import com.witnesses.web.dto.ConnectionDto;

import java.util.List;

public interface ConnectionService {
    /**
     * Create a new connection
     */
    ConnectionDto create(ConnectionDto connectionDTO);

    /**
     * Delete a connection
     */
    void delete(String id);

    /**
     * Update a connection
     */
    ConnectionDto update(String id, ConnectionDto connection);

    /**
     * Get a connection
     */
    ConnectionDto connection(String id);

    /**
     * Get a list of connections
     */
    List<ConnectionDto> connectionList();
}
