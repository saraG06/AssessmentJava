package com.example.assessmentjava.PL.Controller;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDto;
import com.example.assessmentjava.BLL.dto.request.DiscenteRequestDto;
import com.example.assessmentjava.BLL.dto.response.AcademyResponseDto;
import com.example.assessmentjava.BLL.dto.response.DiscenteResponseDto;
import com.example.assessmentjava.BLL.service.abstraction.AcademyService;
import com.example.assessmentjava.BLL.service.abstraction.DiscenteService;
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
@RequestMapping("/api/v2/discente")
@CrossOrigin("http://localhost:8080")
public class DiscenteController {

    private final DiscenteService discenteService;

    @PostMapping
    @Operation(summary = "Metodo per aggiungere un discente")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message="ho creato la risorsa "),
            @ApiResponse(code = 403, message = "Non hai le autorizzazioni per aggiungere un discente")
    })
    public ResponseEntity<Void> save(@RequestBody DiscenteRequestDto discenteRequestDto) {
        discenteService.saveDiscente(discenteRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DiscenteResponseDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(discenteService.findById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value= "Cancellare un discente dall'id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "eseguito"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<DiscenteResponseDto> deleteDiscenteById(@PathVariable Long id){
       discenteService.deleteDiscenteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


