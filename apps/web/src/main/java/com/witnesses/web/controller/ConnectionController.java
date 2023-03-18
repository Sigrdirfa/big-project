package com.witnesses.web.controller;

import com.witnesses.web.dto.ConnectionDto;
import com.witnesses.web.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connection/")
@RequiredArgsConstructor
public class ConnectionController {
    private final ConnectionService connectionService;

    @PostMapping("create")
    public ResponseEntity<ConnectionDto> createConnection(@RequestBody ConnectionDto connectionDTO) {
        return ResponseEntity.ok(connectionService.create(connectionDTO));
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<Void> deleteConnection(@PathVariable String id) {
        connectionService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}/update")
    public ResponseEntity<ConnectionDto> updateConnection(@PathVariable String id, @RequestBody ConnectionDto connection) {
        return ResponseEntity.ok(connectionService.update(id, connection));
    }
    @GetMapping("{id}")
    public ResponseEntity<ConnectionDto> getConnection(@PathVariable String id) {
        return ResponseEntity.ok(connectionService.connection(id));
    }

    @GetMapping("list")
    public ResponseEntity<List<ConnectionDto>> getConnectionList() {
        return ResponseEntity.ok(connectionService.connectionList());
    }
}
