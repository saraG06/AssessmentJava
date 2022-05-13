package com.example.assessmentfinale.PL.controller;

import com.example.assessmentfinale.BLL.dto.request.ModuloRequestDTO;
import com.example.assessmentfinale.BLL.dto.response.ModuloResponseDTO;
import com.example.assessmentfinale.BLL.service.abstraction.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/modulo")
@CrossOrigin("http://localhost:8080")
public class ModuloController {

    private final ModuloService moduloService;

    @PostMapping
    public ResponseEntity<Void> saveModulo(@RequestBody ModuloRequestDTO moduloRequestDTO) {
        moduloService.saveModulo(moduloRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ModuloResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(moduloService.getById(id), HttpStatus.OK);
    }


}
