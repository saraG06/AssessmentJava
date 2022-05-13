package it.unikey.assesmentfedericodc.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assesmentfedericodc.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.DiscenteResponseDTO;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.DiscenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1/discente")
@RequiredArgsConstructor
public class DiscenteController {

    private final DiscenteService discenteService;

    @PostMapping
    @ApiOperation(value= "metodo per inserire un discente")
    @ApiResponses(value= {
            @ApiResponse(code= 201, message= "resource created"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<Void> save(@RequestBody DiscenteRequestDTO discenteRequestDTO){
        discenteService.saveDiscente(discenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path= "/{id}")      //le graffe indicano una variabile
    @ApiOperation(value= "metodo per cercare un discente a partire da un id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<DiscenteResponseDTO> getById(@PathVariable Long id) {

        return new ResponseEntity<>(discenteService.findById(id), HttpStatus.OK);

    }

    @PutMapping(path="/{id}")
    @ApiOperation(value= "metodo per eliminare un discente a partire da un id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id){

        discenteService.deleteDiscenteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value= "metodo per cercare tutti i discenti")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<List<DiscenteResponseDTO>> getAll(){
        return new ResponseEntity<>(discenteService.findAllDiscente(), HttpStatus.OK);
    }
}
