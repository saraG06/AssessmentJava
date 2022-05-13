package it.unikey.assessmentjava.PL.Controller;

import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.Service.Abstraction.AcademyService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/academy/after/data")
@CrossOrigin("http://localhost:8080")
public class GetAcademiesAfterDataController {

    private final AcademyService academyService;

    public GetAcademiesAfterDataController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @GetMapping(path = "/{data}")
    ResponseEntity<List<AcademyResponseDTO>> findAcademyStartAfterData(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate data){
        return new ResponseEntity<>(academyService.findAcademyStartAfterData(data), HttpStatus.FOUND);
    }
}
