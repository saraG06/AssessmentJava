package it.unikey.assessmentjavaleonardopaolini.BLL.service.implementation;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request.AcademyRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response.AcademyResponseMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response.ModuloResponseMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.AcademyService;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Academy;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Modulo;
import it.unikey.assessmentjavaleonardopaolini.DAL.Repository.AcademyRepository;
import it.unikey.assessmentjavaleonardopaolini.DAL.Repository.ModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademyServiceImplementation implements AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;

    private final ModuloResponseMapper moduloResponseMapper;



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

    @Override
    public List<AcademyResponseDTO> findAllAcademyByModulo(String modulo) {
        List<Academy> lista = academyRepository.getAcademyByModulo(modulo);
        return academyResponseMapper.asDTOList(lista);
    }

    @Override
    public ModuloResponseDTO findAcademyInfo(Long id) {
        Modulo m = academyRepository.getAcademyInfo(id);
        return moduloResponseMapper.asDTO(m);
    }

    @Override
    public List<AcademyResponseDTO> findAcademyStartData(LocalDate data) {
        List<Academy> lista = academyRepository.getAcademyStartData(data);
        return academyResponseMapper.asDTOList(lista);
    }
}
