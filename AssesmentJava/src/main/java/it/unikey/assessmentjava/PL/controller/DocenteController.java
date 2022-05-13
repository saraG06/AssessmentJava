package it.unikey.assessmentjava.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.DTO.request.DocenteRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.DocenteResponseDTO;
import it.unikey.assessmentjava.BLL.service.abstraction.DocenteService;
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
    @ApiOperation(value = "Add docente method", notes = "Need an object to add")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created the docente"),
            @ApiResponse(code = 403, message = "No authorization to reach docente")})
    public ResponseEntity<Void> save(@RequestBody DocenteRequestDTO docenteRequestDTO){
        docenteService.saveDocente(docenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Get all docente method")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Docente found"),
            @ApiResponse(code = 403, message = "No authorization to reach docente")})
    public ResponseEntity<List<DocenteResponseDTO>> findAll(){
        return new ResponseEntity<>(docenteService.findAllDocente(),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get docente by Id method", notes = "Need an Id to find a docente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Docente found"),
            @ApiResponse(code = 404, message = "Docente not found")})
    public ResponseEntity<DocenteResponseDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(docenteService.findDocenteById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Delete docente by Id method", notes = "Need an Id to delete a docente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Docente deleted"),
            @ApiResponse(code = 404, message = "Docente not found")})
    public ResponseEntity<Void> delete(@PathVariable Long id){
        docenteService.deleteDocenteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
