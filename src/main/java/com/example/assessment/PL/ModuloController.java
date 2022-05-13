package com.example.assessment.PL;

import com.example.assessment.BLL.dto.request.ModuloRequestDTO;
import com.example.assessment.BLL.dto.response.ModuloResponseDTO;
import com.example.assessment.BLL.service.abstraction.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/modulo")
@CrossOrigin("http://localhost:8080")
public class ModuloController {

    private final ModuloService moduloService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ModuloRequestDTO moduloRequestDTO){
        moduloService.saveModulo(moduloRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ModuloResponseDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(moduloService.findModuloById(id), HttpStatus.OK);
    }
}
