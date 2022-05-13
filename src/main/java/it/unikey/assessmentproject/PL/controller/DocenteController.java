package it.unikey.assessmentproject.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "metodo per aggiungere un docente")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "ha creato effettivamente la risorsa")})
    public ResponseEntity<Void> save(@RequestBody DocenteRequestDTO docenteRequestDTO){


        docenteService.saveDocente(docenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "metodo per cercare un docente dall'id")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "ha trovato la risorsa"),
            @ApiResponse(code = 404, message = "non esiste questo id nel db")})
    public ResponseEntity<DocenteResponseDTO> getById(@PathVariable Long id) {

        try {
            return new ResponseEntity<>(docenteService.getDocenteById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping
    @ApiOperation(value = "metodo per ottenere tutti i docenti")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "ha trovato la risorsa")
    })
    public ResponseEntity<List<DocenteResponseDTO>> getAll(){

        return new ResponseEntity<>(docenteService.getAllDocente(), HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "metodo per cancellare un docente dall'id")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "ha cancellato la risorsa"),
            @ApiResponse(code = 404, message = "non esiste questo id nel db")})
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
