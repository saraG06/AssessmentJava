package it.unikey.assessmentproject.PL.controller;

import it.unikey.assessmentproject.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentproject.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academyFiltroFine")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerFiltroFine {

    private final AcademyService academyService;

    @GetMapping(path = "/{fine}")
    public ResponseEntity<List<AcademyResponseDTO>> getAllAcademyByFine(LocalDate fine){

        return new ResponseEntity<>(academyService.getAcademyByFine(fine), HttpStatus.OK);

    }

}
