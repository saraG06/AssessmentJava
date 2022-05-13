package it.unikey.assessmentjava.PL;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.dto.request.DiscentiRequestDTO;
import it.unikey.assessmentjava.BLL.dto.response.DiscentiResponseDTO;
import it.unikey.assessmentjava.BLL.service.astratti.DiscentiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/discente")
@CrossOrigin("http://localhost:8080")
public class DiscentiController {

    private final DiscentiService discentiService;

    @PostMapping
    @ApiOperation(value= "Metodo per aggiungere un discente")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 201, message= "risorsa creata"),
            @ApiResponse(code= 404, message= "pagina non trovata")
    })
    public ResponseEntity<Void> save(@RequestBody DiscentiRequestDTO discentiRequestDTO) {
        discentiService.saveDiscenti(discentiRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value= "Metodo per cercare un discente dall'id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<DiscentiResponseDTO> getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(discentiService.findById(id),HttpStatus.OK);
        } catch (NullPointerException e){
            return new ResponseEntity<>(discentiService.findById(id),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value= "Metodo per cancellare un discente dall'id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<DiscentiResponseDTO> deleteDiscentiById(@PathVariable Long id){
        discentiService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
