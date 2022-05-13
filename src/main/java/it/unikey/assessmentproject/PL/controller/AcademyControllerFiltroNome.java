package it.unikey.assessmentproject.PL.controller;

import it.unikey.assessmentproject.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentproject.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academyFiltroNome")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerFiltroNome {

    private final AcademyService academyService;

    @GetMapping(path = "/{nome}")
    public ResponseEntity<List<AcademyResponseDTO>> getByNome(@PathVariable String nome){

        return new ResponseEntity<>(academyService.getAllAcademyByNomeContaining(nome), HttpStatus.OK);
    }

}
