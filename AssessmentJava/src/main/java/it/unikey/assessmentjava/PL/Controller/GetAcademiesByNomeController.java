package it.unikey.assessmentjava.PL.Controller;

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

    @GetMapping(path = "/{nome}")
    ResponseEntity<List<AcademyResponseDTO>> findByNome(@PathVariable String nome){
        return new ResponseEntity<>(academyService.findAllByNomeContainingIgnoreCase(nome), HttpStatus.FOUND);
    }
}
