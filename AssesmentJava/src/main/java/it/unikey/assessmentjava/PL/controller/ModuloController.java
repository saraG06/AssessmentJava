package it.unikey.assessmentjava.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.DTO.request.ModuloRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.ModuloResponseDTO;
import it.unikey.assessmentjava.BLL.service.abstraction.ModuloService;
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
    @ApiOperation(value = "Add modulo method", notes = "Need an object to add")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created the modulo"),
            @ApiResponse(code = 403, message = "No authorization to reach modulo")})
    public ResponseEntity<Void> save(@RequestBody ModuloRequestDTO moduloRequestDTO){
        moduloService.saveModulo(moduloRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Get all modulo method")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Modulo found"),
            @ApiResponse(code = 403, message = "No authorization to reach modulo")})
    public ResponseEntity<List<ModuloResponseDTO>> findAll(){
        return new ResponseEntity<>(moduloService.findAllModulo(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get modulo by Id method", notes = "Need an Id to find a modulo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Modulo found"),
            @ApiResponse(code = 404, message = "Modulo not found")})
    public ResponseEntity<ModuloResponseDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(moduloService.findModuloById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Delete modulo by Id method", notes = "Need an Id to delete a modulo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Modulo deleted"),
            @ApiResponse(code = 404, message = "Modulo not found")})
    public ResponseEntity<Void> delete(@PathVariable Long id){
        moduloService.deleteModuloById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
