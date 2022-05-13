package it.unikey.assessmentjava.PL.Controller;

import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.Service.Abstraction.AcademyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/academy/modulo")
@CrossOrigin("http://localhost:8080")
public class GetAcademiesByModuloController {

    private final AcademyService academyService;

    public GetAcademiesByModuloController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @GetMapping(path = "/{modulo}")
    ResponseEntity<List<AcademyResponseDTO>> findByModulo(@PathVariable String modulo){
        return new ResponseEntity<>(academyService.findAllByModulo(modulo), HttpStatus.FOUND);
    }
}
