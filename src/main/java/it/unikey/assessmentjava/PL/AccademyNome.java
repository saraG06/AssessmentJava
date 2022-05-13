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
public class AccademyNome {
    private final AcademyService academyService;

    @GetMapping(path= "/{nome}")
    @ApiOperation(value= "metodo per cercare un academy a partire da UN NOME")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<List<AcademyResponseDTO>> getByNome(@PathVariable String nome) {
        return new ResponseEntity<>(academyService.findByNome(nome), HttpStatus.OK);

    }
}
