package it.unikey.BLL.service.implementation;

import it.unikey.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.BLL.dto.response.DiscenteResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;
import it.unikey.BLL.mapper.implementation.request.AcademyRequestMapper;
import it.unikey.BLL.mapper.implementation.request.DiscenteRequestMapper;
import it.unikey.BLL.mapper.implementation.response.AcademyResponseMapper;
import it.unikey.BLL.mapper.implementation.response.DiscenteResponseMapper;
import it.unikey.BLL.service.abstraction.DiscenteService;
import it.unikey.DAL.entity.Academy;
import it.unikey.DAL.entity.Discente;
import it.unikey.DAL.repository.DiscenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscenteServiceImpl implements DiscenteService {
    private final DiscenteRepository  discenteRepository;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;
    @Override
    public void saveDiscente(DiscenteRequestDTO discenteRequestDTO) {
        Discente d = discenteRequestMapper.asEntity(discenteRequestDTO);
        Academy a = academyRequestMapper.asEntity(discenteRequestDTO.getAcademyRequestDTO());
        d.setAcademy(a);
        discenteRepository.save(d);
    }

    @Override
    public DiscenteResponseDTO findById(Long id) throws IdNotFoundException {
        Discente d = null;
        if (discenteRepository.findById(id).isPresent()) {
            d = discenteRepository.findById(id).get();
            DiscenteResponseDTO dDTO = discenteResponseMapper.asDto(d);
            dDTO.setAcademyResponseDTO(academyResponseMapper.asDto(d.getAcademy()));
            return dDTO;
        }
        if(d == null){
            throw new IdNotFoundException("Id " + id + " non è presente nel db");
        }
        else {
            return discenteResponseMapper.asDto(d);
        }
    }

    @Override
    public void deleteDiscente(Long id) throws IdNotFoundException {
        if(discenteRepository.findById(id).isPresent()) {
            Discente d = discenteRepository.findById(id).get();
            if (d != null) {
                discenteRepository.delete(d);
            }
            else{
                throw new IdNotFoundException("Id " + id + " non è presente nel db");
            }
        }
    }

    @Override
    public List<DiscenteResponseDTO> findAllDiscente() {
        return discenteResponseMapper.asDTOList(discenteRepository.findAll());
    }
}
