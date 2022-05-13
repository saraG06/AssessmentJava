package it.unikey.assessmentjava.PL.Controller;

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

    @PostMapping
    ResponseEntity<Void> save(@RequestBody ModuloRequestDTO moduloRequestDTO){
        moduloService.saveModulo(moduloRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
