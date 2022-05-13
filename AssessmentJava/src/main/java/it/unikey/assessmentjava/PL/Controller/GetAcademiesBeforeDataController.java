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
@RequestMapping("/api/academy/before/data")
@CrossOrigin("http://localhost:8080")
public class GetAcademiesBeforeDataController {

    private final AcademyService academyService;

    public GetAcademiesBeforeDataController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @ApiOperation(value = "Metodo per trovare tutte le Academy finite prima di una certa data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Academy trovata/e"),
            @ApiResponse(code = 404, message = "Nessuna Academy trovate")
    })
    @GetMapping(path = "/{data}")
    ResponseEntity<List<AcademyResponseDTO>> findAcademyEndBeforeData(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data){
        return new ResponseEntity<>(academyService.findAcademyEndBeforeData(data), HttpStatus.FOUND);
    }
}
