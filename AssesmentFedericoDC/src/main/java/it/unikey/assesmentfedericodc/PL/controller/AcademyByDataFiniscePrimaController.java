package it.unikey.assesmentfedericodc.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assesmentfedericodc.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1/academybydatafinisceprima")
@RequiredArgsConstructor
public class AcademyByDataFiniscePrimaController {

    private final AcademyService academyService;

    @GetMapping(path= "/{data}")      //le graffe indicano una variabile
    @ApiOperation(value= "metodo per cercare un academy per data di fine precedente a quella indicata")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<List<AcademyResponseDTO>> getByData(@PathVariable String data) {

        return new ResponseEntity<>(academyService.findByDataFiniscePrima(LocalDate.parse(data)), HttpStatus.OK);

    }
}
