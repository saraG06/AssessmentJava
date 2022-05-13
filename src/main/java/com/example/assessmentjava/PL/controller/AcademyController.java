package com.example.assessmentjava.PL.controller;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDTO;
import com.example.assessmentjava.BLL.dto.response.AcademyResponseDTO;
import com.example.assessmentjava.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path= "/{id}")
    public ResponseEntity<AcademyResponseDTO> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(academyService.findByid(id), HttpStatus.OK);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try{
            academyService.deleteByid(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(NullPointerException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<AcademyResponseDTO>> getAll(){
        return new ResponseEntity<>(academyService.findAllAcademy(), HttpStatus.OK);
    }
}
