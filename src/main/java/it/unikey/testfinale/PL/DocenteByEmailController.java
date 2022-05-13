package it.unikey.testfinale.PL;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.testfinale.BLL.mapper.dto.response.DiscenteResponseDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.DocenteResponseDTO;
import it.unikey.testfinale.BLL.service.abstraction.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/docenteByEmail")
@CrossOrigin("http://localhost:8080")
public class DocenteByEmailController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping(path= "/{email}")
    @ApiOperation(value= "Metodo per cercare un docente dall'email")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<DocenteResponseDTO> getByEmail(@PathVariable String email) {
        try {
            return new ResponseEntity<>(docenteService.findByEmail(email), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
