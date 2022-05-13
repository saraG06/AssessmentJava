package it.unikey.testfinale.PL;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.testfinale.BLL.mapper.dto.request.DocenteRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.DocenteResponseDTO;
import it.unikey.testfinale.BLL.service.abstraction.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/docente")
@CrossOrigin("http://localhost:8080")
public class DocenteController {
    @Autowired
    private DocenteService docenteService;

    @PostMapping
    @ApiOperation(value= "Metodo per aggiungere un docente")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 201, message= "risorsa creata"),
            @ApiResponse(code= 404, message= "pagina non trovata")
    })
    public ResponseEntity<Void> save(@RequestBody DocenteRequestDTO docenteRequestDTO){
        docenteService.saveDocente(docenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path= "/{id}")
    @ApiOperation(value= "Metodo per cercare un docente dall'id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<DocenteResponseDTO> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(docenteService.findById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path="/{id}")
    @ApiOperation(value= "Metodo per cancellare un docente dall'id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try{
            docenteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(EntityNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    @ApiOperation(value= "Metodo per cercare i docenti")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<List<DocenteResponseDTO>> getAll(){
        return new ResponseEntity<>(docenteService.findAllDocente(), HttpStatus.OK);
    }
}
