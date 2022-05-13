package it.unikey.assesmentfedericodc.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assesmentfedericodc.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1/modulo")
@RequiredArgsConstructor
public class ModuloController {

    private final ModuloService moduloService;

    @PostMapping
    @ApiOperation(value= "metodo per inserire un modulo")
    @ApiResponses(value= {
            @ApiResponse(code= 201, message= "resource created"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<Void> save(@RequestBody ModuloRequestDTO moduloRequestDTO){
        moduloService.saveModulo(moduloRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path= "/{id}")
    @ApiOperation(value= "metodo per cercare un modulo a partire da un id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<ModuloResponseDTO> getById(@PathVariable Long id) {

        return new ResponseEntity<>(moduloService.findById(id), HttpStatus.OK);

    }

    @PutMapping(path="/{id}")
    @ApiOperation(value= "metodo per eliminare un modulo a partire da un id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id){

        moduloService.deleteModuloById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value= "metodo per cercare tutti i moduli")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<List<ModuloResponseDTO>> getAll(){
        return new ResponseEntity<>(moduloService.findAllModulo(), HttpStatus.OK);
    }
}
