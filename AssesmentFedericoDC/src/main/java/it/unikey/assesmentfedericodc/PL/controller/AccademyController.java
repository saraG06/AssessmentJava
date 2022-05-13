package it.unikey.assesmentfedericodc.PL.controller;

import it.unikey.assesmentfedericodc.BLL.dto.request.AccademyRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.AccademyResponseDTO;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.AccademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1/accademy")
@RequiredArgsConstructor
public class AccademyController {

    private final AccademyService accademyService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody AccademyRequestDTO accademyRequestDTO){
        accademyService.saveAccademy(accademyRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path= "/{id}")      //le graffe indicano una variabile
    public ResponseEntity<AccademyResponseDTO> getById(@PathVariable Long id) {

        return new ResponseEntity<>(accademyService.findById(id), HttpStatus.OK);

    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        accademyService.deleteAccademyById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<AccademyResponseDTO>> getAll(){
        return new ResponseEntity<>(accademyService.findAllAccademy(), HttpStatus.OK);
    }
}
