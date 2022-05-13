package it.unikey.testfinale.PL;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.testfinale.BLL.mapper.dto.request.ModuloRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.AcademyResponseDTO;
import it.unikey.testfinale.BLL.service.abstraction.AcademyService;
import it.unikey.testfinale.DAL.Entity.Modulo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academybymodulo")
@CrossOrigin("http://localhost:8080")
public class AcademyByModuloController {

    private final AcademyService academyService;

    @GetMapping(path= "/{modulo}")
    @ApiOperation(value= "Metodo per cercare le academy dal modulo")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<List<AcademyResponseDTO>> getByModulo(@PathVariable ModuloRequestDTO moduloRequestDTO) {
        try {
            return new ResponseEntity<>(academyService.findByModulo(moduloRequestDTO), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
