package it.unikey.assessmentjavaleonardopaolini.PL;

import io.swagger.annotations.ApiOperation;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/academyInfo")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerInfo {

    private final AcademyService academyService;

    @GetMapping(path="/{id}")
    @ApiOperation(value = "Metodo per ottenere tutte le info dell'accademy",notes = "I dati relativi all'academy sono in realtà presenti nella tabella modulo (NON FUNZIONANTE!)")
    public ResponseEntity<ModuloResponseDTO> getAcademyInfo(@PathVariable Long id){
        return new ResponseEntity<>(academyService.findAcademyInfo(id), HttpStatus.OK);
    }



}
