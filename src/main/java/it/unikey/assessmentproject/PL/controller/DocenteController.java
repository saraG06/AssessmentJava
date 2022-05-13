package it.unikey.assessmentproject.PL.controller;

import it.unikey.assessmentproject.BLL.DTO.request.DocenteRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.DocenteResponseDTO;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;
import it.unikey.assessmentproject.BLL.service.abstraction.DocenteService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/docente")
@CrossOrigin("http://localhost:8080")
public class DocenteController {

    private final DocenteService docenteService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody DocenteRequestDTO docenteRequestDTO){


        docenteService.saveDocente(docenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DocenteResponseDTO> getById(@PathVariable Long id) {

        try {
            return new ResponseEntity<>(docenteService.getDocenteById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping
    public ResponseEntity<List<DocenteResponseDTO>> getAll(){

        return new ResponseEntity<>(docenteService.getAllDocente(), HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){

        try {
            docenteService.deleteDocenteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
