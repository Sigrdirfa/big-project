package com.witnesses.web.controller;

import com.witnesses.web.dto.WorkSpaceDto;
import com.witnesses.web.service.WorkSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace/")
@RequiredArgsConstructor
public class WorkSpaceController {
    private final WorkSpaceService workSpaceService;

    @PostMapping("create")
    public ResponseEntity<WorkSpaceDto> create(WorkSpaceDto workSpaceDto) {
        return ResponseEntity.ok(workSpaceService.create(workSpaceDto));
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<WorkSpaceDto> delete(@PathVariable String id) {
        workSpaceService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}/update")
    public ResponseEntity<WorkSpaceDto> update(@PathVariable String id, WorkSpaceDto workSpaceDto) {
        return ResponseEntity.ok(workSpaceService.update(id, workSpaceDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<WorkSpaceDto> workSpace(@PathVariable String id) {
        return ResponseEntity.ok(workSpaceService.workspace(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<WorkSpaceDto>> workSpaceList() {
        return ResponseEntity.ok(workSpaceService.workspaceList());
    }

}
