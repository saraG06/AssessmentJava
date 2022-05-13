package it.unikey.assessmentjava.PL.controller;

import it.unikey.assessmentjava.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy/info")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerInfo {

    private final AcademyService academyService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<AcademyResponseDTO> info(@PathVariable Long id){
        return new ResponseEntity<>(academyService.academyDetails(id), HttpStatus.OK);
    }
}
