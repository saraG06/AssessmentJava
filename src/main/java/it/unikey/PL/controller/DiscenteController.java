package it.unikey.PL.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.BLL.dto.response.DiscenteResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;
import it.unikey.BLL.service.abstraction.DiscenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/discente")
@CrossOrigin("http://localhost:8080")
public class DiscenteController {
    private final DiscenteService discenteService;

    @PostMapping
    @ApiOperation(value= "Metodo per salvare un Discente")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<Void> save(@RequestBody DiscenteRequestDTO discenteRequestDTO){
        discenteService.saveDiscente(discenteRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(path = "/{id}")
    @ApiOperation(value= "Metodo per cercare un discente dall'id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<DiscenteResponseDTO> getById(@PathVariable Long id) throws IdNotFoundException {
        return new ResponseEntity<>(discenteService.findById(id),HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    @ApiOperation(value= "Metodo per cancellare un discente dal db")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<Long> delete(@PathVariable Long id) throws IdNotFoundException{
        discenteService.deleteDiscente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    @ApiOperation(value= "Metodo per cercare tutti i discenti")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "richiesta ricevuta ed eseguita"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<List<DiscenteResponseDTO>> findAll(){
        return new ResponseEntity<>(discenteService.findAllDiscente(),HttpStatus.OK);
    }

}
