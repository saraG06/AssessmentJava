package it.unikey.assessmentjava.PL;

import it.unikey.assessmentjava.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.service.astratti.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1/academydalnome")
@RequiredArgsConstructor
public class AcademyDalNome {
    private final AcademyService academyService;

    @GetMapping(path= "/{NOME}")
    public ResponseEntity<List<AcademyResponseDTO>> getByNome(@PathVariable String nome) {
        return new ResponseEntity<>(academyService.findByNome(nome), HttpStatus.OK);

    }
}
