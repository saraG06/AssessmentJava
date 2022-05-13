package it.unikey.testfinale.PL;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.testfinale.BLL.mapper.dto.response.AcademyResponseDTO;
import it.unikey.testfinale.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academyDetails")
@CrossOrigin("http://localhost:8080")
public class AcademyDetailsController {

    private AcademyService academyService;

    @GetMapping(path="/{id}")
    @ApiOperation(value= "Metodo per cercare i dettagli delle academy")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<List<AcademyResponseDTO>> getDetails(@PathVariable Long id){
        return new ResponseEntity<>(academyService.findDetails(id), HttpStatus.OK);
    }
}
