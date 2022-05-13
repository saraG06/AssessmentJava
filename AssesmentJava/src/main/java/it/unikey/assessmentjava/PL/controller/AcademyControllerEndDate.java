package it.unikey.assessmentjava.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy/enddate")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerEndDate {

    private final AcademyService academyService;

    @GetMapping(path = "/{date}")
    @ApiOperation(value = "Get all academy ending before this date method")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Academy found"),
            @ApiResponse(code = 403, message = "No authorization to reach academy")})
    public ResponseEntity<List<AcademyResponseDTO>> endDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return new ResponseEntity<>(academyService.endDate(date), HttpStatus.OK);
    }
}
