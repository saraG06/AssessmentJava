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
@RequestMapping("/api/v1/academy")
@CrossOrigin("http://localhost:8080")
public class AcademyController {

    private final AcademyService academyService;

    @PostMapping
    @ApiOperation(value = "Add academy method", notes = "Need an object to add")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created the academy"),
            @ApiResponse(code = 403, message = "No authorization to reach academy")})
    public ResponseEntity<Void> save(@RequestBody AcademyRequestDTO academyRequestDTO){
        academyService.saveAcademy(academyRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Get all academy method")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Academy found"),
            @ApiResponse(code = 403, message = "No authorization to reach academy")})
    public ResponseEntity<List<AcademyResponseDTO>> findAll(){
        return new ResponseEntity<>(academyService.findAllAcademy(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get academy by Id method", notes = "Need an Id to find an academy")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Academy found"),
            @ApiResponse(code = 404, message = "Academy not found")})
    public ResponseEntity<AcademyResponseDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(academyService.findAcademyById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Delete academy by Id method", notes = "Need an Id to delete an academy")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Academy deleted"),
            @ApiResponse(code = 404, message = "Academy not found")})
    public ResponseEntity<Void> delete(@PathVariable Long id){
        academyService.deleteAcademyById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
