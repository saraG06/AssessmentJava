package it.unikey.assesmentfedericodc.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assesmentfedericodc.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1/academy")
@RequiredArgsConstructor
public class AcademyController {

    private final AcademyService academyService;

    @PostMapping
    @ApiOperation(value= "metodo per aggiungere un academy")
    @ApiResponses(value= {
            @ApiResponse(code= 201, message= "resource created"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<Void> save(@RequestBody AcademyRequestDTO academyRequestDTO){
        academyService.saveAcademy(academyRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path= "/{id}")      //le graffe indicano una variabile
    @ApiOperation(value= "metodo per cercare un academy a partire da un id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<AcademyResponseDTO> getById(@PathVariable Long id) {
        try{
            ResponseEntity<AcademyResponseDTO> a = new ResponseEntity<>(academyService.findById(id), HttpStatus.OK) ;
            return a;
        }catch(EntityNotFoundException e){
            ResponseEntity<AcademyResponseDTO> a = new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
            return a;
        }


    }

    @PutMapping(path="/{id}")
    @ApiOperation(value= "metodo per eliminare un academy a partire da un id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id){

        academyService.deleteAcademyById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value= "metodo per cercare tutte le academy")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<List<AcademyResponseDTO>> getAll(){
        return new ResponseEntity<>(academyService.findAllAcademy(), HttpStatus.OK);
    }
}
