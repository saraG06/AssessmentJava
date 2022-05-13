package it.unikey.assessmentjava.PL.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.Dto.Request.DiscenteRequestDTO;
import it.unikey.assessmentjava.BLL.Service.Abstraction.DiscenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discente")
@CrossOrigin("http://localhost:8080")
public class DiscenteController {

    private final DiscenteService discenteService;

    public DiscenteController(DiscenteService discenteService) {
        this.discenteService = discenteService;
    }

    @ApiOperation(value = "Metodo per salvare un Discente", notes = "Necessario un oggetto Discente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Discente creato"),
            @ApiResponse(code = 403, message = "Inserimento non valido")
    })
    @PostMapping
    ResponseEntity<Void> save(@RequestBody DiscenteRequestDTO discenteRequestDTO){
        discenteService.saveDiscente(discenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
