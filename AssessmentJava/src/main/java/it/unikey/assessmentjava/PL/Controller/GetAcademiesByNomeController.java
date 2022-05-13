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
@RequestMapping("/api/academy/nome")
@CrossOrigin("http://localhost:8080")
public class GetAcademiesByNomeController {

    private final AcademyService academyService;

    public GetAcademiesByNomeController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @ApiOperation(value = "Metodo per trovare tutte le Academy presenti da una stringa nome", notes = "Necessario inserire una stringa nome, verranno prese tutte le academy che contengono, anche se solo in parte, la stringa inserita nel path")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Academy trovata/e"),
            @ApiResponse(code = 404, message = "Nessuna Academy trovate")
    })
    @GetMapping(path = "/{nome}")
    ResponseEntity<List<AcademyResponseDTO>> findByNome(@PathVariable String nome){
        return new ResponseEntity<>(academyService.findAllByNomeContainingIgnoreCase(nome), HttpStatus.FOUND);
    }
}
