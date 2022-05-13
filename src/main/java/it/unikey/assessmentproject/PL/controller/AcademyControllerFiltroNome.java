package it.unikey.assessmentproject.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentproject.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentproject.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academyFiltroNome")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerFiltroNome {

    private final AcademyService academyService;

    @GetMapping(path = "/{nome}")
    @ApiOperation(value = "metodo per cercare le academy tramite una stringa contenuta nel nome")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "ha trovato la risorsa")})
    public ResponseEntity<List<AcademyResponseDTO>> getByNome(@PathVariable String nome){

        return new ResponseEntity<>(academyService.getAllAcademyByNomeContaining(nome), HttpStatus.OK);
    }

}
