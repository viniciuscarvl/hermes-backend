package br.com.fcxlabs.hermes.controllers;

import br.com.fcxlabs.hermes.dtos.sequential.saveSequentialRequest;
import br.com.fcxlabs.hermes.services.SequentialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/sequentials")
public class SequentialController {
    private SequentialService sequentialService;

    public SequentialController(SequentialService sequentialService) {
        this.sequentialService = sequentialService;
    }

    @PostMapping
    public ResponseEntity<?> saveSequential(@RequestBody saveSequentialRequest request) {
        return ResponseEntity.ok(sequentialService.saveSequential(request));
    }
}
