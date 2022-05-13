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
@RequestMapping("/api/v1/academy/betweendate")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerBetweenDate {

    private final AcademyService academyService;

    @GetMapping(path = "/{dateone}/{datetwo}")
    @ApiOperation(value = "Get all academy taking place between two dates method")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Academy found"),
            @ApiResponse(code = 403, message = "No authorization to reach academy")})
    public ResponseEntity<List<AcademyResponseDTO>> betweenDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateone, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate datetwo){
        return new ResponseEntity<>(academyService.betweenDate(dateone,datetwo), HttpStatus.OK);
    }
}
