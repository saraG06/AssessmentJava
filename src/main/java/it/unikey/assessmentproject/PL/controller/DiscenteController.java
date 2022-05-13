package it.unikey.assessmentproject.PL.controller;

import it.unikey.assessmentproject.BLL.DTO.request.DiscenteRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.DiscenteResponseDTO;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;
import it.unikey.assessmentproject.BLL.service.abstraction.DiscenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/discente")
@CrossOrigin("http://localhost:8080")
public class DiscenteController {

    private final DiscenteService discenteService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody DiscenteRequestDTO discenteRequestDTO) {

        discenteService.saveDiscente(discenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<DiscenteResponseDTO> getById(@PathVariable Long id){

        try {
            return new ResponseEntity<>(discenteService.getDiscenteById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    public ResponseEntity<List<DiscenteResponseDTO>> getAll(){

        return new ResponseEntity<>(discenteService.getAllDiscente(), HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        try {
            discenteService.deleteDiscenteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
