package it.unikey.assessmentproject.PL.controller;

import it.unikey.assessmentproject.BLL.DTO.request.ModuloRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.ModuloResponseDTO;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;
import it.unikey.assessmentproject.BLL.service.abstraction.ModuloService;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<ModuloResponseDTO> getById(@PathVariable Long id){

        try {
            return new ResponseEntity<>(moduloService.getModuloById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    public ResponseEntity<List<ModuloResponseDTO>> getAll(){

       return new ResponseEntity<>(moduloService.getAllModulo(),HttpStatus.OK) ;

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){

        try {
            moduloService.deleteModuloById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
