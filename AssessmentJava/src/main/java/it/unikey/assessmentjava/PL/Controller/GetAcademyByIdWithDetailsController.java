package it.unikey.assessmentjava.PL.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.Service.Abstraction.AcademyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/academy/dettagli")
@CrossOrigin("http://localhost:8080")
public class GetAcademyByIdWithDetailsController {

    private final AcademyService academyService;

    public GetAcademyByIdWithDetailsController(AcademyService academyService) {
        this.academyService = academyService;
    }


    @ApiOperation(value = "Metodo per trovare una Academy da un id inserito", notes = "Necessario inserire un Long id nel path che corrisponde con l'id dell'Academy da selezionare")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Academy trovata/e"),
            @ApiResponse(code = 404, message = "Nessuna Academy trovate")
    })
    @GetMapping(path = "/{id}")
    ResponseEntity<AcademyResponseDTO> findAllWithDetails(@PathVariable Long id){
        return new ResponseEntity<>(academyService.findByIdWithDetails(id), HttpStatus.FOUND);
    }
}
