package com.example.assessmentjava.PL.controller;

import com.example.assessmentjava.BLL.dto.request.ModuloRequestDTO;
import com.example.assessmentjava.BLL.dto.response.ModuloResponseDTO;
import com.example.assessmentjava.BLL.service.abstraction.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping(path= "/{id}")
    public ResponseEntity<ModuloResponseDTO> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(moduloService.findByid(id), HttpStatus.OK);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try{
            moduloService.deleteByid(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(NullPointerException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<ModuloResponseDTO>> getAll(){
        return new ResponseEntity<>(moduloService.findAllModuli(), HttpStatus.OK);
    }
}
