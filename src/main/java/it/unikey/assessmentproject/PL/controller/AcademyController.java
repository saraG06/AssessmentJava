package it.unikey.assessmentproject.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentproject.BLL.DTO.request.AcademyRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;
import it.unikey.assessmentproject.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy")
@CrossOrigin("http://localhost:8080")
public class AcademyController {

    private final AcademyService academyService;

    @PostMapping
    @ApiOperation(value = "metodo per aggiungere un'academy")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "ha creato effettivamente la risorsa")})
    public ResponseEntity<Void> save(@RequestBody AcademyRequestDTO academyRequestDTO){

        academyService.saveAcademy(academyRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "metodo per cercare un'academy dall'id")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "ha trovato la risorsa"),
            @ApiResponse(code = 404, message = "non esiste questo id nel db")})
    public ResponseEntity<AcademyResponseDTO> getById(@PathVariable Long id) {

        try {
            return new ResponseEntity<>(academyService.getAcademyById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping
    @ApiOperation(value = "metodo per ottenere tutte le academy")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "ha trovato la risorsa")
            })
    public ResponseEntity<List<AcademyResponseDTO>> getall(){

        return new ResponseEntity<>(academyService.getAllAcademy(),HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "metodo per cancellare un'academy dall'id")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "ha cancellato la risorsa"),
            @ApiResponse(code = 404, message = "non esiste questo id nel db")})
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        try {
            academyService.deleteAcademyById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
