package com.example.assessmentjava.PL.Controller;

import com.example.assessmentjava.BLL.dto.request.ModuloRequestDto;
import com.example.assessmentjava.BLL.dto.response.ModuloResponseDto;
import com.example.assessmentjava.BLL.service.abstraction.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/modulo")
@CrossOrigin("http://localhost:8080")
public class ModuloController {

    private final ModuloService moduloService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ModuloRequestDto moduloRequestDto) {
        moduloService.saveModulo(moduloRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ModuloResponseDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(moduloService.findById(id), HttpStatus.OK);
    }
}

