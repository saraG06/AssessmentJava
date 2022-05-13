package com.example.assessment.PL;

import com.example.assessment.BLL.dto.request.DiscenteRequestDTO;
import com.example.assessment.BLL.dto.response.DiscenteResponseDTO;
import com.example.assessment.BLL.service.abstraction.DiscenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/discente")
@CrossOrigin("http://localhost:8080")
public class DiscenteController {

    private final DiscenteService discenteService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody DiscenteRequestDTO discenteRequestDTO){
        discenteService.saveDiscente(discenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DiscenteResponseDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(discenteService.findDiscenteById(id), HttpStatus.OK);
    }
}
