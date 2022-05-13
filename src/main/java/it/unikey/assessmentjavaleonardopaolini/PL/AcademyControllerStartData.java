package it.unikey.assessmentjavaleonardopaolini.PL;

import io.swagger.annotations.ApiOperation;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/academyStartData")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerStartData {

    private final AcademyService academyService;

    @GetMapping(path="/{data}")
    @ApiOperation(value = "GET di tutte le Academy con la data di inizio uguale o conseguente la data specificata")
    public ResponseEntity<List<AcademyResponseDTO>> getAcademyStartData(@PathVariable LocalDate data){
        return new ResponseEntity<>(academyService.findAcademyStartData(data), HttpStatus.OK);
    }
}
