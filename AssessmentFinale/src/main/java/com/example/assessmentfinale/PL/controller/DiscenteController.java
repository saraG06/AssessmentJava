package com.example.assessmentfinale.PL.controller;

import com.example.assessmentfinale.BLL.dto.request.DiscenteRequestDTO;
import com.example.assessmentfinale.BLL.dto.response.DiscenteResponseDTO;
import com.example.assessmentfinale.BLL.service.abstraction.DiscenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discente")
@CrossOrigin("http://localhost:8080")
public class DiscenteController {

    private final DiscenteService discenteService;

    @PostMapping
    public ResponseEntity<Void> saveDiscente(@RequestBody DiscenteRequestDTO discenteRequestDTO) {
        discenteService.saveDiscente(discenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DiscenteResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(discenteService.getById(id), HttpStatus.OK);
    }

}
