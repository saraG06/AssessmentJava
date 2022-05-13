package it.unikey.assesmentfedericodc.BLL.service.implementation;

import it.unikey.assesmentfedericodc.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.DiscenteResponseDTO;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.AcademyRequestMapper;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.AcademyResponseMapper;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.DiscenteRequestMapper;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.DiscenteResponseMapper;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.DiscenteService;
import it.unikey.assesmentfedericodc.DAL.entity.Discente;
import it.unikey.assesmentfedericodc.DAL.repository.DiscenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscenteServiceImpl implements DiscenteService {

    private final DiscenteRepository discenteRepository;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;
    private  final AcademyResponseMapper academyResponseMapper;
    private final AcademyRequestMapper academyRequestMapper;

    @Override
    public void saveDiscente(DiscenteRequestDTO discenteRequestDTO) {
        Discente d = discenteRequestMapper.asEntity(discenteRequestDTO);
        d.setAcademy(academyRequestMapper.asEntity(discenteRequestDTO.getAcademyRequestDTO()));
        discenteRepository.save(d);
    }

    @Override
    public DiscenteResponseDTO findById(Long id) {
        Discente d = discenteRepository.findById(id).get();
        if(d != null){
            DiscenteResponseDTO dr = discenteResponseMapper.asDTO(d);
            //   dr.setAcademyResponseDTO(academyResponseMapper.asDTO(d.getAcademy()));
            return dr;
        }else throw new EntityNotFoundException();

    }

    @Override
    public void deleteDiscenteById(Long id) {
        if(discenteRepository.existsById(id))
            discenteRepository.deleteById(id);
        else throw new EntityNotFoundException();

    }

    @Override
    public List<DiscenteResponseDTO> findAllDiscente() {
        List<Discente> dList = discenteRepository.findAll() ;
        List<DiscenteResponseDTO> drList =  new ArrayList<>();
        for(Discente d : dList){
            DiscenteResponseDTO dr = discenteResponseMapper.asDTO(d);
       //     dr.setAcademyResponseDTO(academyResponseMapper.asDTO(d.getAcademy()));
            drList.add(dr);
        }
        return drList;
    }
}
