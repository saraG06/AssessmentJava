package it.unikey.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.BLL.dto.request.AcademyRequestDTO;
import it.unikey.BLL.dto.response.AcademyResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;
import it.unikey.BLL.exception.NameNotFoundException;
import it.unikey.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy2")
@CrossOrigin("http://localhost:8080")
public class AcademyController2 {
    private final AcademyService academyService;

    @GetMapping(path = "/{nome}")
    @ApiOperation(value= "Metodo per cercare un'academy dal nome")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<List<AcademyResponseDTO>> findByNome(@PathVariable String nome) throws NameNotFoundException {
        return new ResponseEntity<>(academyService.findByNome(nome), HttpStatus.OK);
    }
    @GetMapping(path = "/modulo/{modulo}")
    @ApiOperation(value= "Metodo per cercare un'academy dal modulo")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<List<AcademyResponseDTO>> findByModulo(@PathVariable String modulo) throws NameNotFoundException {
        return new ResponseEntity<>(academyService.findByModulo(modulo), HttpStatus.OK);
    }
}
