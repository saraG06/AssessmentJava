package it.unikey.assessmentjava.BLL.service.implementation;

import it.unikey.assessmentjava.BLL.DTO.request.DiscenteRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.DiscenteResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.implementation.AcademyRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementation.DiscenteRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementation.DiscenteResponseMapper;
import it.unikey.assessmentjava.BLL.service.abstraction.DiscenteService;
import it.unikey.assessmentjava.DAL.entity.Discente;
import it.unikey.assessmentjava.DAL.repository.DiscenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscenteServiceImpl implements DiscenteService {

    private final DiscenteRepository discenteRepository;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;
    private final AcademyRequestMapper academyRequestMapper;

    @Override
    public void saveDiscente(DiscenteRequestDTO discenteRequestDTO) throws NoSuchFieldException {
        if(discenteRequestDTO.getCodiceFiscale().length() == 16){
            Discente d = discenteRequestMapper.asEntity(discenteRequestDTO);
            d.setAcademy(academyRequestMapper.asEntity(discenteRequestDTO.getAcademyRequestDTO()));
            discenteRepository.save(d);
        }else
            throw new NoSuchFieldException();

    }

    @Override
    public List<DiscenteResponseDTO> findAllDiscente() {
        List<Discente> dList = discenteRepository.findAll();
        return discenteResponseMapper.asDTOList(dList);
    }

    @Override
    public DiscenteResponseDTO findDiscenteById(Long id) throws NullPointerException{
        Discente d = discenteRepository.getById(id);
        if(id != null)
            return discenteResponseMapper.asDTO(d);
        else
            throw new NullPointerException();
    }

    @Override
    public void deleteDiscenteById(Long id) throws NullPointerException{
        if(discenteRepository.existsById(id))
            discenteRepository.deleteById(id);
        else
            throw new NullPointerException();
    }
}
