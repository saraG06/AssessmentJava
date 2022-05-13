package it.unikey.assessmentjava.PL.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.Service.Abstraction.AcademyService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/academy/between/date")
@CrossOrigin("http://localhost:8080")
public class GetAcademiesBetweenDatesController {
    private final AcademyService academyService;

    public GetAcademiesBetweenDatesController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @ApiOperation(value = "Metodo per trovare tutte le Academy presenti che si sono svolte nel periodo inidcato dalle due date")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Academy trovata/e"),
            @ApiResponse(code = 404, message = "Nessuna Academy trovate")
    })
    @GetMapping(path = "/{data1}/{data2}")
    ResponseEntity<List<AcademyResponseDTO>> findAllByDataBetweenTwoDates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data1, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data2){
        return new ResponseEntity<>(academyService.findAllByDataBetweenTwoDates(data1, data2), HttpStatus.FOUND);
    }
}
