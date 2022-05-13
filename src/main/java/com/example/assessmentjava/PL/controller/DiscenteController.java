package com.example.assessmentjava.PL.controller;

import com.example.assessmentjava.BLL.dto.request.DiscenteRequestDTO;
import com.example.assessmentjava.BLL.dto.response.DiscenteResponseDTO;
import com.example.assessmentjava.BLL.service.abstraction.DiscenteService;
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
    public ResponseEntity<Void> save(@RequestBody DiscenteRequestDTO discenteRequestDTO){
        discenteService.saveDiscente(discenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path= "/{id}")
    public ResponseEntity<DiscenteResponseDTO> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(discenteService.findByid(id), HttpStatus.OK);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try{
            discenteService.deleteByid(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(NullPointerException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<DiscenteResponseDTO>> getAll(){
        return new ResponseEntity<>(discenteService.findAllDiscenti(), HttpStatus.OK);
    }
}
