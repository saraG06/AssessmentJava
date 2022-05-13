package it.unikey.assesmentfedericodc.BLL.service.implementation;

import it.unikey.assesmentfedericodc.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.*;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.AcademyService;
import it.unikey.assesmentfedericodc.DAL.entity.Academy;
import it.unikey.assesmentfedericodc.DAL.repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {

    private final AcademyRepository academyRepository;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;
    private  final AcademyResponseMapper academyResponseMapper;
    private final AcademyRequestMapper academyRequestMapper;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;

    @Override
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {
        Academy a = academyRequestMapper.asEntity(academyRequestDTO);
        a.setDiscenti(discenteRequestMapper.asEntityList(academyRequestDTO.getDiscenteRequestDTOList()));
        a.setModuli(moduloRequestMapper.asEntityList(academyRequestDTO.getModuloRequestDTOList()));
        academyRepository.save(a);
    }

    @Override
    public AcademyResponseDTO findById(Long id) {
        Academy a = academyRepository.findById(id).get();
        AcademyResponseDTO ar = academyResponseMapper.asDTO(a);
        ar.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenti()));
        ar.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuli()));
        return ar ;
    }

    @Override
    public void deleteAcademyById(Long id) {
        academyRepository.deleteById(id);
    }

    @Override
    public List<AcademyResponseDTO> findAllAcademy() {
        return responseDTOListConverter(academyRepository.findAll());
    }

    @Override
    public List<AcademyResponseDTO> findByNome(String nome) {
        return responseDTOListConverter(academyRepository.findByNome(nome));
    }

    @Override
    public List<AcademyResponseDTO> findByModulo(String nomeModulo) {
        return responseDTOListConverter(academyRepository.findByModulo(nomeModulo));
    }

    private List<AcademyResponseDTO> responseDTOListConverter(List<Academy> cList){
        List<AcademyResponseDTO> arList =  new ArrayList<>();
        for(Academy a : cList){
            AcademyResponseDTO ar = academyResponseMapper.asDTO(a);
            ar.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenti()));
            ar.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuli()));
            arList.add(ar);
        }
        return arList;
    }
}
