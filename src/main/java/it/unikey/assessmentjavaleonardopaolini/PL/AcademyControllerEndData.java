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
@RequestMapping("/api/academyEndData")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerEndData {

    private final AcademyService academyService;

    @GetMapping(path="/{data}")
    @ApiOperation(value = "GET di tutte le Academy con la data finale inferiore o uguale alla data specificata")
    public ResponseEntity<List<AcademyResponseDTO>> getAcademyEndData(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data){
        return new ResponseEntity<>(academyService.findAcademyEndData(data), HttpStatus.OK);
    }
}
