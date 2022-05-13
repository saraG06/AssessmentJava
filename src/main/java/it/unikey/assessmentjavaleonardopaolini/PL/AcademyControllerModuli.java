package it.unikey.assessmentjavaleonardopaolini.PL;

import io.swagger.annotations.ApiOperation;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/academyModuli")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerModuli {

    private final AcademyService academyService;

    @GetMapping(path="/{modulo}")
    @ApiOperation(value = "Get delle Academy in base al Modulo")
    public ResponseEntity<List<AcademyResponseDTO>> getAcademyByModulo(@PathVariable String modulo){
        return new ResponseEntity<>(academyService.findAllAcademyByModulo(modulo), HttpStatus.OK);
    }


}
