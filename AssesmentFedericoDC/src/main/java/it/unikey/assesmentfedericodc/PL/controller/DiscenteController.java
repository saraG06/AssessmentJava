package it.unikey.assesmentfedericodc.PL.controller;

import it.unikey.assesmentfedericodc.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.DiscenteResponseDTO;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.DiscenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1/discente")
@RequiredArgsConstructor
public class DiscenteController {

    private final DiscenteService discenteService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody DiscenteRequestDTO discenteRequestDTO){
        discenteService.saveDiscente(discenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path= "/{id}")      //le graffe indicano una variabile
    public ResponseEntity<DiscenteResponseDTO> getById(@PathVariable Long id) {

        return new ResponseEntity<>(discenteService.findById(id), HttpStatus.OK);

    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        discenteService.deleteDiscenteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<DiscenteResponseDTO>> getAll(){
        return new ResponseEntity<>(discenteService.findAllDiscente(), HttpStatus.OK);
    }
}
