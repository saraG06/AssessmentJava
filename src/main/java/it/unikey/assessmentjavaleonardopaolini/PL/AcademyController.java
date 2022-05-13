package it.unikey.assessmentjavaleonardopaolini.PL;

import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Inserimento di un'Academy")
    public ResponseEntity<Void> save(@RequestBody AcademyRequestDTO academyRequestDTO){
        try {
            academyService.saveAcademy(academyRequestDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (NullPointerException n){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path="/{nome}")
    @ApiOperation(value = "Get dell'academy con il nome specificato")
    public ResponseEntity<AcademyResponseDTO>  getByNome(@PathVariable String nome){
        return new ResponseEntity<>(academyService.findAcademyPerNome(nome),HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Get di tutte le Academy presenti nel DB")
    public ResponseEntity<List<AcademyResponseDTO>>  getAllAcademy(){
        return new ResponseEntity<>(academyService.findAllAcademy(),HttpStatus.OK);
    }

    @PutMapping(path="/{id}")
    @ApiOperation(value = "Rimozione dell'Academy tramite ID")
    public ResponseEntity<Void> deleteAcademyById(@PathVariable Long id){

        try {
            academyService.deleteAcademyById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NullPointerException n){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
