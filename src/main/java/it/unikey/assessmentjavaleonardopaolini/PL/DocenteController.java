package it.unikey.assessmentjavaleonardopaolini.PL;

import io.swagger.annotations.ApiOperation;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.DocenteRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/docente")
@CrossOrigin("http://localhost:8080")
public class DocenteController {

    private final DocenteService docenteService;

    @PostMapping
    @ApiOperation(value = "Inserimento di un Docente nel DB")
    public ResponseEntity<Void> save(@RequestBody DocenteRequestDTO docenteRequestDTO){
        try {
            docenteService.saveDocente(docenteRequestDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (NullPointerException n){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
