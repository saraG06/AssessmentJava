package com.example.assessment.PL;

import com.example.assessment.BLL.dto.request.AcademyRequestDTO;
import com.example.assessment.BLL.dto.response.AcademyResponseDTO;
import com.example.assessment.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy")
@CrossOrigin("http://localhost:8080")
public class AcademyController {

    private final AcademyService academyService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody AcademyRequestDTO academyRequestDTO){
        academyService.saveAcademy(academyRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AcademyResponseDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(academyService.findAcademyById(id), HttpStatus.OK);
    }
}
