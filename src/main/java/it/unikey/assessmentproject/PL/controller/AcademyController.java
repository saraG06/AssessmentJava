package it.unikey.assessmentproject.PL.controller;

import it.unikey.assessmentproject.BLL.DTO.request.AcademyRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;
import it.unikey.assessmentproject.BLL.service.abstraction.AcademyService;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<AcademyResponseDTO> getById(@PathVariable Long id) {

        try {
            return new ResponseEntity<>(academyService.getAcademyById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping
    public ResponseEntity<List<AcademyResponseDTO>> getall(){

        return new ResponseEntity<>(academyService.getAllAcademy(),HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        try {
            academyService.deleteAcademyById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
