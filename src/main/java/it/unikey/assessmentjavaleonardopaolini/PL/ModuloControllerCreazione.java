package it.unikey.assessmentjavaleonardopaolini.PL;

import io.swagger.annotations.ApiOperation;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.ModuloRequestDTOCreazione;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/moduloCreazione")
@CrossOrigin("http://localhost:8080")
public class ModuloControllerCreazione {

    private final ModuloService moduloService;


    @PostMapping
    @ApiOperation(value = "Inserimento di un Modulo con relazioni già esistenti nel DB",notes = "NON FUNZIONA!")
    public ResponseEntity<Void> save(@RequestBody ModuloRequestDTOCreazione moduloRequestDTOCreazione){
        try {
            moduloService.saveModuloCreazione(moduloRequestDTOCreazione);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (NullPointerException n){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
