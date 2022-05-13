package com.example.assessmentjava.PL.Controller;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDto;
import com.example.assessmentjava.BLL.dto.response.AcademyResponseDto;
import com.example.assessmentjava.BLL.service.abstraction.AcademyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/academy")
@CrossOrigin("http://localhost:8080")
public class AcademyController {

    private final AcademyService academyService;

    @PostMapping
    @Operation(summary = "Metodo per aggiungere una academy")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "ho creato la risorsa "),
            @ApiResponse(code = 403, message = "Non hai le autorizzazioni per aggiungere una academy")
    })
    public ResponseEntity<Void> save(@RequestBody AcademyRequestDto academyRequestDto) {
        academyService.saveAcademy(academyRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AcademyResponseDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(academyService.findById(id), HttpStatus.OK);
    }



    @PutMapping(path = "/{id}")
    @ApiOperation(value= "Cancellare un'academy dall'id")
    @ApiResponses(value= {
            @ApiResponse(code= 200, message= "eseguito"),
            @ApiResponse(code= 404, message= "risorsa non trovata")
    })
    public ResponseEntity<AcademyResponseDto> deleteAcademyById(@PathVariable Long id){
        academyService.deleteAcademyById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
