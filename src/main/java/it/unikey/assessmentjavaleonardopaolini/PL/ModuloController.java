package it.unikey.assessmentjavaleonardopaolini.PL;

import io.swagger.annotations.ApiOperation;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/modulo")
@CrossOrigin("http://localhost:8080")
public class ModuloController {

    private final ModuloService moduloService;

    @PostMapping
    @ApiOperation(value = "Inserimento di un Modulo con conseguente creazione delle sue relazioni")
    public ResponseEntity<Void> save(@RequestBody ModuloRequestDTO moduloRequestDTO){
        try {
            moduloService.saveModulo(moduloRequestDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (NullPointerException n){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @ApiOperation(value = "GetAll  con visualizzazione completa su POSTMAN delle relazioni")
    public ResponseEntity<List<ModuloResponseDTO>>  getAllModulo(){
        return new ResponseEntity<>(moduloService.findAllModulo(),HttpStatus.OK);
    }

    @PutMapping(path="/{id}")
    @ApiOperation(value = "Rimozione di un Modulo tramite ID")
    public ResponseEntity<Void> deleteAziendaById(@PathVariable Long id){

        try {
            moduloService.deleteModuloById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NullPointerException n){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
