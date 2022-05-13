package com.example.assessmentjava.PL.controller;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDTO;
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
@RequestMapping("/api/v1/academycustom")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerCustom {
    private final AcademyService academyService;

    @GetMapping(path = "/{nome}")
    @ApiOperation(value= "metodo trovare tutte le academy che contengono la risorsa")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<List<AcademyResponseDTO>> findByName(@PathVariable String nome, AcademyRequestDTO academyRequestDTO) throws NullPointerException {
        return new ResponseEntity<>(academyService.findByName(nome), HttpStatus.OK);
    }
}
