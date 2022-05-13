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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy")
@CrossOrigin("http://localhost:8080")
public class AcademyController {

    private final AcademyService academyService;

    @PostMapping
    @ApiOperation(value = "getById", notes = "get academy by id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created the academy"),
            @ApiResponse(code = 403, message = "No authorization to reach academy")})
    public ResponseEntity<Void> save(@RequestBody AcademyRequestDTO academyRequestDTO) {
        academyService.saveAcademy(academyRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "getById", notes = "get academy by id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created the academy"),
            @ApiResponse(code = 403, message = "No authorization to reach academy")})
    public ResponseEntity<AcademyResponseDTO> getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(academyService.findById(id),HttpStatus.OK);
        } catch (NullPointerException e){
            return new ResponseEntity<>(academyService.findById(id),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "deleteAcademyById", notes = "delete academy by id")
    public ResponseEntity<AcademyResponseDTO> deleteAcademyById(@PathVariable Long id){
        academyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
