package it.unikey.assessmentproject.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentproject.BLL.DTO.request.DiscenteRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.DiscenteResponseDTO;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;
import it.unikey.assessmentproject.BLL.service.abstraction.DiscenteService;
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
    @ApiOperation(value = "metodo per aggiungere un discente")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "ha creato effettivamente la risorsa")})
    public ResponseEntity<Void> save(@RequestBody DiscenteRequestDTO discenteRequestDTO) {

        discenteService.saveDiscente(discenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @GetMapping(path = "/{id}")
    @ApiOperation(value = "metodo per cercare un discente dall'id")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "ha trovato la risorsa"),
            @ApiResponse(code = 404, message = "non esiste questo id nel db")})
    public ResponseEntity<DiscenteResponseDTO> getById(@PathVariable Long id){

        try {
            return new ResponseEntity<>(discenteService.getDiscenteById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    @ApiOperation(value = "metodo per ottenere tutti i discenti")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "ha trovato la risorsa")
    })
    public ResponseEntity<List<DiscenteResponseDTO>> getAll(){

        return new ResponseEntity<>(discenteService.getAllDiscente(), HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "metodo per cancellare un discente dall'id")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "ha cancellato la risorsa"),
            @ApiResponse(code = 404, message = "non esiste questo id nel db")})
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        try {
            discenteService.deleteDiscenteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
