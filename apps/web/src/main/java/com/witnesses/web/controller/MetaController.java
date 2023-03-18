package com.witnesses.web.controller;

import com.witnesses.web.service.MetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meta/")
@RequiredArgsConstructor
public class MetaController {

    private final MetaService metaService;
}
