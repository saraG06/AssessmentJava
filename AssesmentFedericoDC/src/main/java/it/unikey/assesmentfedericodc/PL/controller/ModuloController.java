package it.unikey.assesmentfedericodc.PL.controller;

import it.unikey.assesmentfedericodc.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1/modulo")
@RequiredArgsConstructor
public class ModuloController {

    private final ModuloService moduloService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ModuloRequestDTO moduloRequestDTO){
        moduloService.saveModulo(moduloRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path= "/{id}")      //le graffe indicano una variabile
    public ResponseEntity<ModuloResponseDTO> getById(@PathVariable Long id) {

        return new ResponseEntity<>(moduloService.findById(id), HttpStatus.OK);

    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        moduloService.deleteModuloById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ModuloResponseDTO>> getAll(){
        return new ResponseEntity<>(moduloService.findAllModulo(), HttpStatus.OK);
    }
}
