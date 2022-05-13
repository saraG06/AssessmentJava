package it.unikey.assesmentfedericodc.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assesmentfedericodc.BLL.dto.request.PeriodoDTO;
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
@RequestMapping("/api/v1/academybydatacompresa")
@RequiredArgsConstructor
public class AcademyByDataCompresaController {

    private final AcademyService academyService;

    @GetMapping()
    @ApiOperation(value= "metodo per cercare un academy il cui inizio e fine sono compresi tra due date")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "request received and executed"),
            @ApiResponse(code= 404, message= "resource not found")
    })
    public ResponseEntity<List<AcademyResponseDTO>> getByDataCompresa(@RequestBody PeriodoDTO periodoDTO) {

        return new ResponseEntity<>(academyService.findByDataCompresa(periodoDTO.getDataMin(),periodoDTO.getDataMax()), HttpStatus.OK);

    }
}
