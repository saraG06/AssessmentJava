package it.unikey.assessmentjava.PL.Controller;

import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.Service.Abstraction.AcademyService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/academy/between/date")
@CrossOrigin("http://localhost:8080")
public class GetAcademiesBetweenDatesController {
    private final AcademyService academyService;

    public GetAcademiesBetweenDatesController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @GetMapping(path = "/{data1}/{data2}")
    ResponseEntity<List<AcademyResponseDTO>> findAllByDataInizioBetweenTwoDates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data1, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data2){
        return new ResponseEntity<>(academyService.findAllByDataInizioBetweenTwoDates(data1, data2), HttpStatus.FOUND);
    }
}
