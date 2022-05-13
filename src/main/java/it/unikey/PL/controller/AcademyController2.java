package it.unikey.PL.controller;

import it.unikey.BLL.dto.request.AcademyRequestDTO;
import it.unikey.BLL.dto.response.AcademyResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;
import it.unikey.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy2")
@CrossOrigin("http://localhost:8080")
public class AcademyController2 {
    private final AcademyService academyService;

    @GetMapping(path = "/{nome}")
    public ResponseEntity<List<AcademyResponseDTO>> findByNome(@PathVariable String nome) throws IdNotFoundException {
        return new ResponseEntity<>(academyService.findByNome(nome), HttpStatus.OK);
    }
}
