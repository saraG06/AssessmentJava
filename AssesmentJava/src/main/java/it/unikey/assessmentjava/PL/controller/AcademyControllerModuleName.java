package it.unikey.assessmentjava.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy/modulename")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerModuleName {

    private final AcademyService academyService;

    @GetMapping(path = "/{nomemodulo}")
    @ApiOperation(value = "Get all academy with this modulo name method")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Academy found"),
            @ApiResponse(code = 403, message = "No authorization to reach academy")})
    public ResponseEntity<List<AcademyResponseDTO>> findByModuleName(@PathVariable String nomemodulo){
        return new ResponseEntity<>(academyService.academyNomeModulo(nomemodulo), HttpStatus.OK);
    }
}
