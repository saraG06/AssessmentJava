package it.unikey.assessmentproject.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentproject.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentproject.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academyFiltroInizio")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerFiltroInizio {

    private final AcademyService academyService;

    @GetMapping(path = "/{inizio}")
    @ApiOperation(value = "metodo per cercare le academy tramite data di inizio")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "ha trovato la risorsa")})
    public ResponseEntity<List<AcademyResponseDTO>> getAllByInizio(LocalDate inizio){

        return new ResponseEntity<>(academyService.getAcademyByInizio(inizio), HttpStatus.OK);
    }

}
