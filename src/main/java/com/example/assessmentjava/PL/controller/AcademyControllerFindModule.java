package com.example.assessmentjava.PL.controller;

import com.example.assessmentjava.BLL.dto.response.AcademyResponseDTO;
import com.example.assessmentjava.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academycontrollerfindmodule")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerFindModule {
    private final AcademyService academyService;

    @GetMapping(path = "/modulo/{modulo}")
    public ResponseEntity<List<AcademyResponseDTO>> findByModulo(@PathVariable String modulo) throws NullPointerException {
        return new ResponseEntity<>(academyService.findByModulo(modulo), HttpStatus.OK);
    }
}
