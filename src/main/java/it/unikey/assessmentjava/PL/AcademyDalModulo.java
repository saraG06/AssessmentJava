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
public class AcademyDalModulo {
    private final AcademyService academyService;

    @GetMapping(path= "/{NOME}")
    @ApiOperation(value= "Metodo per cercare un academy dal modulo")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 201, message= "risorsa creata"),
            @ApiResponse(code= 404, message= "pagina non trovata")
    })
    public ResponseEntity<List<AcademyResponseDTO>> getByModulo(@PathVariable String nome) {
        return new ResponseEntity<>(academyService.findByModulo(nome), HttpStatus.OK);

    }
}
