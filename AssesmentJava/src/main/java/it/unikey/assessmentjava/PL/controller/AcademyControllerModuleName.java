package it.unikey.assessmentjava.PL.controller;

import it.unikey.assessmentjava.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy/modulename")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerModuleName {

    private final AcademyService academyService;

    @GetMapping(path = "/{nomemodulo}")
    public ResponseEntity<List<AcademyResponseDTO>> findByModuleName(@PathVariable String nomemodulo){
        return new ResponseEntity<>(academyService.academyNomeModulo(nomemodulo), HttpStatus.OK);
    }
}
