package it.unikey.assessmentproject.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentproject.BLL.DTO.request.ModuloRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentproject.BLL.service.abstraction.AcademyService;
import it.unikey.assessmentproject.DAL.entity.Modulo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academyFiltroModulo")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerFiltroModulo {

    private final AcademyService academyService;

    @GetMapping(path = "/{modulo}")
    @ApiOperation(value = "metodo per cercare le academy tramite il modulo")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "ha trovato la risorsa")})
    public ResponseEntity<List<AcademyResponseDTO>> getAllByModulo(@PathVariable ModuloRequestDTO modulo){

        return new ResponseEntity<>(academyService.getAcademyByModuloListContainingModulo(modulo), HttpStatus.OK);

    }

}
