package it.unikey.assessmentjava.PL;

import it.unikey.assessmentjava.BLL.dto.request.DiscentiRequestDTO;
import it.unikey.assessmentjava.BLL.dto.response.DiscentiResponseDTO;
import it.unikey.assessmentjava.BLL.service.astratti.DiscentiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/discente")
@CrossOrigin("http://localhost:8080")
public class DiscentiController {

    private final DiscentiService discentiService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody DiscentiRequestDTO discentiRequestDTO) {
        discentiService.saveDiscenti(discentiRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DiscentiResponseDTO> getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(discentiService.findById(id),HttpStatus.OK);
        } catch (NullPointerException e){
            return new ResponseEntity<>(discentiService.findById(id),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DiscentiResponseDTO> deleteDiscentiById(@PathVariable Long id){
        discentiService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
