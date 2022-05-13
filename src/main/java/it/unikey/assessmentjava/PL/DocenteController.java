package it.unikey.assessmentjava.PL;

import it.unikey.assessmentjava.BLL.dto.request.DocenteRequestDTO;
import it.unikey.assessmentjava.BLL.dto.response.DocenteResponseDTO;
import it.unikey.assessmentjava.BLL.service.astratti.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/docente")
@CrossOrigin("http://localhost:8080")
public class DocenteController {

    private final DocenteService docenteService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody DocenteRequestDTO docenteRequestDTO) {
        docenteService.saveDocente(docenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DocenteResponseDTO> getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(docenteService.findById(id),HttpStatus.OK);
        } catch (NullPointerException e){
            return new ResponseEntity<>(docenteService.findById(id),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DocenteResponseDTO> deleteDocenteById(@PathVariable Long id){
        docenteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
