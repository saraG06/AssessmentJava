package it.unikey.assessmentjava.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.DTO.request.DiscenteRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.DiscenteResponseDTO;
import it.unikey.assessmentjava.BLL.service.abstraction.DiscenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/discente")
@CrossOrigin("http://localhost:8080")
public class DiscenteController {

    private final DiscenteService discenteService;

    @PostMapping
    @ApiOperation(value = "Add discente method", notes = "Need an object to add")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created the discente"),
            @ApiResponse(code = 403, message = "No authorization to reach discente")})
    public ResponseEntity<Void> save(@RequestBody DiscenteRequestDTO discenteRequestDTO){
        try {
            discenteService.saveDiscente(discenteRequestDTO);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Get all discente method")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Discente found"),
            @ApiResponse(code = 403, message = "No authorization to reach discente")})
    public ResponseEntity<List<DiscenteResponseDTO>> findAll(){
        return new ResponseEntity<>(discenteService.findAllDiscente(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get discente by Id method", notes = "Need an Id to find a discente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Discente found"),
            @ApiResponse(code = 404, message = "Discente not found")})
    public ResponseEntity<DiscenteResponseDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(discenteService.findDiscenteById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Delete discente by Id method", notes = "Need an Id to delete a discente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Discente deleted"),
            @ApiResponse(code = 404, message = "Discente not found")})
    public ResponseEntity<Void> delete(@PathVariable Long id){
        discenteService.deleteDiscenteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
