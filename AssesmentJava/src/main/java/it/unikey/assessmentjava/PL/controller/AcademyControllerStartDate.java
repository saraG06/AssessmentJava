package it.unikey.assessmentjava.PL.controller;

import it.unikey.assessmentjava.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy/startdate")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerStartDate {

    private final AcademyService academyService;

    @GetMapping(path = "/{date}")
    public ResponseEntity<List<AcademyResponseDTO>> startDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return new ResponseEntity<>(academyService.startDate(date), HttpStatus.OK);
    }
}
