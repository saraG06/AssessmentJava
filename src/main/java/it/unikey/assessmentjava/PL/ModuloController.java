package it.unikey.assessmentjava.PL;

import it.unikey.assessmentjava.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assessmentjava.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assessmentjava.BLL.service.astratti.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/modulo")
@CrossOrigin("http://localhost:8080")
public class ModuloController {

    private final ModuloService moduloService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ModuloRequestDTO moduloRequestDTO) {
        moduloService.saveModulo(moduloRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ModuloResponseDTO> getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(moduloService.findById(id),HttpStatus.OK);
        } catch (NullPointerException e){
            return new ResponseEntity<>(moduloService.findById(id),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ModuloResponseDTO> deleteNoduloById(@PathVariable Long id){
        moduloService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
