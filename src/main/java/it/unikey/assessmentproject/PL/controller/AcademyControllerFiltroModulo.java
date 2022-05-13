package it.unikey.assessmentproject.PL.controller;

import it.unikey.assessmentproject.BLL.DTO.request.ModuloRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentproject.BLL.service.abstraction.AcademyService;
import it.unikey.assessmentproject.DAL.entity.Modulo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academyFiltroModulo")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerFiltroModulo {

    private final AcademyService academyService;

    @GetMapping(path = "/{modulo}")
    public ResponseEntity<List<AcademyResponseDTO>> getAllByModulo(@PathVariable ModuloRequestDTO modulo){

        return new ResponseEntity<>(academyService.getAcademyByModuloListContainingModulo(modulo), HttpStatus.OK);

    }

}
