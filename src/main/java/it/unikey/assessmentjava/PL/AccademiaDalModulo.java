package it.unikey.assessmentjava.PL;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.service.astratti.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1/academydalmodulo")
@RequiredArgsConstructor
public class AccademiaDalModulo {
    private final AcademyService academyService;

    @GetMapping(path= "/{NOME}")      //le graffe indicano una variabile
    @ApiOperation(value= "metodo per trovare l'academy dal modulo")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<List<AcademyResponseDTO>> getByModulo(@PathVariable String nome) {
        return new ResponseEntity<>(academyService.findByModulo(nome), HttpStatus.OK);

    }
}
