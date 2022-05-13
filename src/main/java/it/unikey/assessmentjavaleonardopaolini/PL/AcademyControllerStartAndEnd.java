package it.unikey.assessmentjavaleonardopaolini.PL;

import io.swagger.annotations.ApiOperation;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/academyStartAndEnd")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerStartAndEnd {

    private final AcademyService academyService;

    @GetMapping(path="/{datafine,datainizio}")
    @ApiOperation(value = "GET di tutte le Academy con la data di inizio e fine comprese nelle date specificate", notes = "NON FUNZIONA!")
    public ResponseEntity<List<AcademyResponseDTO>> getAcademyStartAndEndData(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate datafine,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate datainizio ){
        return new ResponseEntity<>(academyService.findAcademyStartAndEndBetween(datafine,datainizio), HttpStatus.OK);
    }
}
