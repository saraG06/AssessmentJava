package it.unikey.assesmentfedericodc.BLL.service.implementation;

import it.unikey.assesmentfedericodc.BLL.dto.request.AccademyRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.AccademyResponseDTO;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.*;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.AccademyService;
import it.unikey.assesmentfedericodc.DAL.entity.Accademy;
import it.unikey.assesmentfedericodc.DAL.repository.AccademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AccademyServiceImpl implements AccademyService {

    private final AccademyRepository accademyRepository;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;
    private  final AccademyResponseMapper accademyResponseMapper;
    private final AccademyRequestMapper accademyRequestMapper;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;

    @Override
    public void saveAccademy(AccademyRequestDTO accademyRequestDTO) {
        Accademy a = accademyRequestMapper.asEntity(accademyRequestDTO);
        a.setDiscenti(discenteRequestMapper.asEntityList(accademyRequestDTO.getDiscenteRequestDTOList()));
        a.setModuli(moduloRequestMapper.asEntityList(accademyRequestDTO.getModuloRequestDTOList()));
        accademyRepository.save(a);
    }

    @Override
    public AccademyResponseDTO findById(Long id) {
        Accademy a = accademyRepository.findById(id).get();
        AccademyResponseDTO ar = accademyResponseMapper.asDTO(a);
        ar.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenti()));
        ar.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuli()));
        return ar ;
    }

    @Override
    public void deleteAccademyById(Long id) {
        accademyRepository.deleteById(id);
    }

    @Override
    public List<AccademyResponseDTO> findAllAccademy() {
        return responseDTOListConverter(accademyRepository.findAll());
    }

    private List<AccademyResponseDTO> responseDTOListConverter(List<Accademy> cList){
        List<AccademyResponseDTO> arList =  new ArrayList<>();
        for(Accademy a : cList){
            AccademyResponseDTO ar = accademyResponseMapper.asDTO(a);
            ar.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenti()));
            ar.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuli()));
            arList.add(ar);
        }
        return arList;
    }
}
