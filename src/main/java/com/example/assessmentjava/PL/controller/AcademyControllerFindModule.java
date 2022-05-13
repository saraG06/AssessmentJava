package com.example.assessmentjava.PL.controller;

import com.example.assessmentjava.BLL.dto.response.AcademyResponseDTO;
import com.example.assessmentjava.BLL.service.abstraction.AcademyService;
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
@RequestMapping("/api/v1/academycontrollerfindmodule")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerFindModule {
    private final AcademyService academyService;

    @GetMapping(path = "/modulo/{modulo}")
    @ApiOperation(value= "metodo trovare tutte le accademy che contengono il modulo")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<List<AcademyResponseDTO>> findByModulo(@PathVariable String modulo) throws NullPointerException {
        return new ResponseEntity<>(academyService.findByModulo(modulo), HttpStatus.OK);
    }
}
