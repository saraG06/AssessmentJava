package it.unikey.assessmentjava.PL.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.unikey.assessmentjava.BLL.DTO.request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.service.abstraction.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy/byname")
@CrossOrigin("http://localhost:8080")
public class AcademyControllerByName {

    private final AcademyService academyService;

    @GetMapping(path = "/{nome}")
    @ApiOperation(value = "Get all academy with this name method")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Academy found"),
            @ApiResponse(code = 403, message = "No authorization to reach academy")})
    public ResponseEntity<List<AcademyResponseDTO>> findByName(@PathVariable String nome){
        return new ResponseEntity<>(academyService.academyConNome(nome), HttpStatus.OK);
    }
}
