package it.unikey.assesmentfedericodc.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assesmentfedericodc.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1/academybynome")
@RequiredArgsConstructor
public class AcademyByNomeController {

    private final AcademyService academyService;

    @GetMapping(path= "/{nome}")      //le graffe indicano una variabile
    @ApiOperation(value= "metodo per cercare un academy a partire da UN NOME")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<List<AcademyResponseDTO>> getByNome(@PathVariable String nome) {

        return new ResponseEntity<>(academyService.findByNome(nome), HttpStatus.OK);

    }
}
