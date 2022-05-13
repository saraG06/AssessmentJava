package it.unikey.PL.controller;

import it.unikey.BLL.dto.request.DocenteRequestDTO;
import it.unikey.BLL.dto.response.DocenteResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;
import it.unikey.BLL.service.abstraction.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/docente")
@CrossOrigin("http://localhost:8080")
public class DocenteController {
    private final DocenteService docenteService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody DocenteRequestDTO docenteRequestDTO){
        docenteService.saveDocente(docenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<DocenteResponseDTO> getById(@PathVariable Long id) throws IdNotFoundException {
        return new ResponseEntity<>(docenteService.findById(id),HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) throws IdNotFoundException{
        docenteService.deleteDocente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<DocenteResponseDTO>> findAll(){
        return new ResponseEntity<>(docenteService.findAllDocente(),HttpStatus.OK);
    }
}
