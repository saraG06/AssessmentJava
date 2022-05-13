package com.example.assessmentjava.PL.controller;

import com.example.assessmentjava.BLL.dto.request.ModuloRequestDTO;
import com.example.assessmentjava.BLL.dto.response.ModuloResponseDTO;
import com.example.assessmentjava.BLL.service.abstraction.ModuloService;
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
@RequestMapping("/api/v1/modulo")
@CrossOrigin("http://localhost:8080")
public class ModuloController {
    private final ModuloService moduloService;

    @PostMapping
    @ApiOperation(value= "metodo per creare un modulo")
    @ApiResponses(value= {
            @ApiResponse(code= 201, message= "Creata!"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<Void> save(@RequestBody ModuloRequestDTO moduloRequestDTO){
        moduloService.saveModulo(moduloRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path= "/{id}")
    @ApiOperation(value= "metodo per trovare un modulo con un id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<ModuloResponseDTO> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(moduloService.findByid(id), HttpStatus.OK);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path="/{id}")
    @ApiOperation(value= "metodo per eliminare un modulo con un id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try{
            moduloService.deleteByid(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(NullPointerException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    @ApiOperation(value= "metodo trovare tutti i moduli")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<List<ModuloResponseDTO>> getAll(){
        return new ResponseEntity<>(moduloService.findAllModuli(), HttpStatus.OK);
    }
}
