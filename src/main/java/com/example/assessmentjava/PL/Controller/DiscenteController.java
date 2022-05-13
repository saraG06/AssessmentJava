package com.example.assessmentjava.PL.Controller;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDto;
import com.example.assessmentjava.BLL.dto.request.DiscenteRequestDto;
import com.example.assessmentjava.BLL.dto.response.AcademyResponseDto;
import com.example.assessmentjava.BLL.dto.response.DiscenteResponseDto;
import com.example.assessmentjava.BLL.service.abstraction.AcademyService;
import com.example.assessmentjava.BLL.service.abstraction.DiscenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/discente")
@CrossOrigin("http://localhost:8080")
public class DiscenteController {

    private final DiscenteService discenteService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody DiscenteRequestDto discenteRequestDto) {
        discenteService.saveDiscente(discenteRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DiscenteResponseDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(discenteService.findById(id), HttpStatus.OK);
    }
}


