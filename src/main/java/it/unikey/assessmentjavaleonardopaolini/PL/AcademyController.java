package it.unikey.assessmentjavaleonardopaolini.PL;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/academy")
@CrossOrigin("http://localhost:8080")
public class AcademyController {

    private final AcademyService academyService;


    @PostMapping
    public ResponseEntity<Void> save(@RequestBody AcademyRequestDTO academyRequestDTO){
        try {
            academyService.saveAcademy(academyRequestDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (NullPointerException n){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path="/{nome}")
    public ResponseEntity<AcademyResponseDTO>  getByNome(@PathVariable String nome){
        return new ResponseEntity<>(academyService.findAcademyPerNome(nome),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AcademyResponseDTO>>  getAllAcademy(){
        return new ResponseEntity<>(academyService.findAllAcademy(),HttpStatus.OK);
    }

}
