package com.example.assessmentjava.PL.Controller;

import com.example.assessmentjava.BLL.dto.request.ModuloRequestDto;
import com.example.assessmentjava.BLL.dto.response.AcademyResponseDto;
import com.example.assessmentjava.BLL.dto.response.ModuloResponseDto;
import com.example.assessmentjava.BLL.service.abstraction.ModuloService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/modulo")
@CrossOrigin("http://localhost:8080")
public class ModuloController {

    private final ModuloService moduloService;

    @PostMapping
    @Operation(summary = "Metodo per aggiungere un modulo")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message="ho creato la risorsa "),
            @ApiResponse(code = 403, message = "Non hai le autorizzazioni per aggiungere un modulo")
    })
    public ResponseEntity<Void> save(@RequestBody ModuloRequestDto moduloRequestDto) {
        moduloService.saveModulo(moduloRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ModuloResponseDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(moduloService.findById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value= "Cancellare un modulo dall'id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "eseguito"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<ModuloResponseDto> deleteModuloById(@PathVariable Long id){
        moduloService.deleteModuloById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

