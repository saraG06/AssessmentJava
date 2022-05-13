package it.unikey.assessmentjava.PL;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.service.astratti.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

public class AcademyDataInizio {
    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/api/v1/academydatainizio")
    @CrossOrigin("http://localhost:8080")
    public class AcademyController4 {

        private final AcademyService academyService;

        @GetMapping
        @ApiOperation(value = "metodo che prende le academy iniziate e finite in un certo lasso di tempo")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Done"),
                @ApiResponse(code = 404, message = "Element not found")
        })
        public ResponseEntity<List<AcademyResponseDTO>> getAcademyByDataInizio(LocalDate datainizio){
            return new ResponseEntity<>(academyService.getAcademyByDataInizio(datainizio), HttpStatus.OK);
        }
    }
}
