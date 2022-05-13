package it.unikey.assessmentjava.PL.Controller;

import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.Service.Abstraction.AcademyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/academy/dettagli")
@CrossOrigin("http://localhost:8080")
public class GetAcademiesWithDetailsController {

    private final AcademyService academyService;

    public GetAcademiesWithDetailsController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @GetMapping
    ResponseEntity<List<AcademyResponseDTO>> findAllWithDetails(){
        return new ResponseEntity<>(academyService.findAllWithDetails(), HttpStatus.FOUND);
    }
}
