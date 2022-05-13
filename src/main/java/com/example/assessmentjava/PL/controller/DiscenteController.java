package com.example.assessmentjava.PL.controller;

import com.example.assessmentjava.BLL.dto.request.DiscenteRequestDTO;
import com.example.assessmentjava.BLL.dto.response.DiscenteResponseDTO;
import com.example.assessmentjava.BLL.service.abstraction.DiscenteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value= "metodo per creare un discente")
    @ApiResponses(value= {
            @ApiResponse(code= 201, message= "Creata!"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<Void> save(@RequestBody DiscenteRequestDTO discenteRequestDTO){
        discenteService.saveDiscente(discenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path= "/{id}")
    @ApiOperation(value= "metodo per trovare un discente con un id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<DiscenteResponseDTO> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(discenteService.findByid(id), HttpStatus.OK);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path="/{id}")
    @ApiOperation(value= "metodo per eliminare un discente con un id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try{
            discenteService.deleteByid(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(NullPointerException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    @ApiOperation(value= "metodo trovare tutti i discenti")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<List<DiscenteResponseDTO>> getAll(){
        return new ResponseEntity<>(discenteService.findAllDiscenti(), HttpStatus.OK);
    }
}
