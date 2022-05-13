package com.example.assessmentfinale.PL.controller;

import com.example.assessmentfinale.BLL.dto.request.AcademyRequestDTO;
import com.example.assessmentfinale.BLL.dto.response.AcademyResponseDTO;
import com.example.assessmentfinale.BLL.service.abstraction.AcademyService;
import com.example.assessmentfinale.DAL.entities.Academy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/academy")
@CrossOrigin("http://localhost:8080")
public class AcademyController {

    private final AcademyService academyService;

    @PostMapping
    public ResponseEntity<Void> saveAcademy(@RequestBody AcademyRequestDTO academyRequestDTO) {
        academyService.saveAcademy(academyRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
        public ResponseEntity<List<Academy>> getAll() {
           return new ResponseEntity<>(academyService.getAllAcademy(), HttpStatus.OK);
    }

    @GetMapping ("/ByNome")
        public ResponseEntity<AcademyResponseDTO> getAcademyByName (String nome) {
            return new ResponseEntity<>(academyService.getAcademyByName(nome), HttpStatus.OK);
    }


}
