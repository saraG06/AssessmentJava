package it.unikey.assessmentjava.PL.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.Dto.Request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.Service.Abstraction.AcademyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/academy")
@CrossOrigin("http://localhost:8080")
public class AcademyController {

    private final AcademyService academyService;

    public AcademyController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @ApiOperation(value = "Metodo per salvare una Academy", notes = "Necessario un oggetto Academy")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Academy salvata correttamente"),
            @ApiResponse(code = 401, message = "Inserimento non valido")
    })
    @PostMapping
    ResponseEntity<Void> save(@RequestBody AcademyRequestDTO academyRequestDTO){
        academyService.saveAcademy(academyRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @ApiOperation(value = "Metodo per trovare tutte le Academy presenti")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Academy trovata/e"),
            @ApiResponse(code = 404, message = "Nessuna Academy trovate")
    })
    @GetMapping
    ResponseEntity<List<AcademyResponseDTO>> findAll(){
        return new ResponseEntity<>(academyService.findAll(), HttpStatus.FOUND);
    }
}
