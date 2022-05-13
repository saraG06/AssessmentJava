package it.unikey.assestmentjava.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assestmentjava.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assestmentjava.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy_6")
@CrossOrigin("http://localhost:8080")
public class AcademyController6 {
    private final AcademyService academyService;

    @GetMapping
    @ApiOperation(value = "Method to get all info about an Academy")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Done"),
            @ApiResponse(code = 404, message = "Element not found")
    })
    public ResponseEntity<AcademyResponseDTO> getAcademyInfo(String nome){
        return new ResponseEntity<>(academyService.getAcademyInfo(nome), HttpStatus.OK);
    }
}
