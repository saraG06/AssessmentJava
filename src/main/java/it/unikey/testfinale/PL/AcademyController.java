package it.unikey.testfinale.PL;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.testfinale.BLL.Exception.AlreadyExistsException;
import it.unikey.testfinale.BLL.Exception.ConflictBetweenAttributesException;
import it.unikey.testfinale.BLL.mapper.dto.request.AcademyRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.AcademyResponseDTO;
import it.unikey.testfinale.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy")
@CrossOrigin("http://localhost:8080")
public class AcademyController {
    @Autowired
    private final AcademyService academyService;

    @PostMapping
    @ApiOperation(value= "Metodo per aggiungere un'academy")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 201, message= "risorsa creata"),
            @ApiResponse(code= 404, message= "pagina non trovata")
    })
    public ResponseEntity<Void> save(@RequestBody AcademyRequestDTO academyRequestDTO) throws AlreadyExistsException, ConflictBetweenAttributesException {
        academyService.saveAcademy(academyRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path= "/{id}")
    @ApiOperation(value= "Metodo per cercare un'academy dall'id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<AcademyResponseDTO> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(academyService.findById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path="/{id}")
    @ApiOperation(value= "Metodo per cancellare un'academy dall'id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try{
            academyService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(EntityNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    @ApiOperation(value= "Metodo per cercare le academy")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<List<AcademyResponseDTO>> getAll(){
        return new ResponseEntity<>(academyService.findAllAcademy(), HttpStatus.OK);
    }
}
