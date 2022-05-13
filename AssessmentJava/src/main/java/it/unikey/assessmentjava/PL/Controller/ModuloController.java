package it.unikey.assessmentjava.PL.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.Dto.Request.ModuloRequestDTO;
import it.unikey.assessmentjava.BLL.Service.Abstraction.ModuloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/modulo")
@CrossOrigin("http://localhost:8080")
public class ModuloController {

    private final ModuloService moduloService;

    public ModuloController(ModuloService moduloService) {
        this.moduloService = moduloService;
    }

    @ApiOperation(value = "Metodo per salvare un Modulo", notes = "Necessario un oggetto Modulo")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Modulo salvata correttamente"),
            @ApiResponse(code = 401, message = "Inserimento non valido")
    })
    @PostMapping
    ResponseEntity<Void> save(@RequestBody ModuloRequestDTO moduloRequestDTO){
        moduloService.saveModulo(moduloRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
