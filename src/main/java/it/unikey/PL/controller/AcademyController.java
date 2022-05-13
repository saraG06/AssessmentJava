package it.unikey.PL.controller;

import it.unikey.BLL.dto.request.AcademyRequestDTO;
import it.unikey.BLL.dto.response.AcademyResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;
import it.unikey.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
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
    public ResponseEntity<AcademyResponseDTO> getById(@PathVariable Long id) throws IdNotFoundException{
        return new ResponseEntity<>(academyService.findById(id),HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) throws IdNotFoundException{
        academyService.deleteAcademy(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<AcademyResponseDTO>> findAll(){
        return new ResponseEntity<>(academyService.findAllAcademy(),HttpStatus.OK);
    }

}
