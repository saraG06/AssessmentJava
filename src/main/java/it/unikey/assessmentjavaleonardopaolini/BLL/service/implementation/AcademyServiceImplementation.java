package it.unikey.assessmentjavaleonardopaolini.BLL.service.implementation;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request.AcademyRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response.AcademyResponseMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.AcademyService;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Academy;
import it.unikey.assessmentjavaleonardopaolini.DAL.Repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademyServiceImplementation implements AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;



    @Override
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {
        Academy a = academyRequestMapper.asEntity(academyRequestDTO);
        academyRepository.save(a);
    }

    @Override
    public AcademyResponseDTO findAcademyPerNome(String nome) {
        Academy a = academyRepository.getAcademyByNome(nome);
        return academyResponseMapper.asDTO(a);
    }

    @Override
    public List<AcademyResponseDTO> findAllAcademy() {
        List<Academy> lista = academyRepository.findAll();
        return academyResponseMapper.asDTOList(lista);
    }
}
