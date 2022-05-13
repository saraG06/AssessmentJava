package it.unikey.assessmentjava.PL.Controller;

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

    @PostMapping
    ResponseEntity<Void> save(@RequestBody DiscenteRequestDTO discenteRequestDTO){
        discenteService.saveDiscente(discenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
