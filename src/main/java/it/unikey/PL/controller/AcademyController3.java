package it.unikey.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.BLL.dto.response.AcademyResponseDTO;
import it.unikey.BLL.exception.DateNotValidException;
import it.unikey.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy3")
@CrossOrigin("http://localhost:8080")
public class AcademyController3 {
    private final AcademyService academyService;

    @GetMapping(path= "/dopo/{data}")      //le graffe indicano una variabile
    @ApiOperation(value= "Metodo per cercare un'Academy per data di inzio successiva a quella inserita")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<List<AcademyResponseDTO>> getByDataDopo(@PathVariable String data) throws DateNotValidException {
        return new ResponseEntity<>(academyService.findByDataDopo(LocalDate.parse(data)), HttpStatus.OK);
    }
    @GetMapping(path= "/prima/{data}")      //le graffe indicano una variabile
    @ApiOperation(value= "Metodo per cercare un'Academy per data di fine precedente a quella inserita")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<List<AcademyResponseDTO>> getByDataPrima(@PathVariable String data) throws DateNotValidException {
        return new ResponseEntity<>(academyService.findByDataPrima(LocalDate.parse(data)), HttpStatus.OK);
    }
    @GetMapping(path = "/compresa/{data1}/{data2}")
    @ApiOperation(value= "Metodo per cercare un'Academy il cui inizio e fine sono compresi tra due date")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<List<AcademyResponseDTO>> getByDataCompresa(@PathVariable String data1, @PathVariable String data2) throws DateNotValidException {
        return new ResponseEntity<>(academyService.findByDataCompresa(LocalDate.parse(data1),LocalDate.parse(data2)), HttpStatus.OK);
    }
}
