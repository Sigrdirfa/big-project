package com.witnesses.web.controller;

import com.witnesses.web.dto.EngineDto;
import com.witnesses.web.service.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engine/")
@RequiredArgsConstructor
public class EngineController {

    private final EngineService engineService;

    @PostMapping("signin")
    public ResponseEntity<Void> engineSignIn(@RequestBody EngineDto engineDTO) {
        engineService.signIn(engineDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}/update")
    public ResponseEntity<Void> engineUpdate(@PathVariable String id, @RequestBody EngineDto engineDTO) {
        engineService.update(id, engineDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<EngineDto> engine(@PathVariable String id) {
        return ResponseEntity.ok(engineService.engine(id));
    }

    @GetMapping("list")
    public ResponseEntity<List<EngineDto>> engineList() {
        return ResponseEntity.ok(engineService.engineList());
    }

}
