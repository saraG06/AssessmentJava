package it.unikey.assessmentjava.BLL.service.implementazioni;

import it.unikey.assessmentjava.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.implementazioni.request.AcademyRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementazioni.request.DiscentiRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementazioni.request.ModuloRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementazioni.response.AcademyResponseMapper;
import it.unikey.assessmentjava.BLL.mapper.implementazioni.response.ModuloResponseMapper;
import it.unikey.assessmentjava.BLL.service.astratti.AcademyService;
import it.unikey.assessmentjava.DAL.Entity.Academy;
import it.unikey.assessmentjava.DAL.Repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademyServiceImplementazioni implements AcademyService {

    private final AcademyRepository academyRepository;
    private final DiscentiRequestMapper discenteRequestMapper;
    private final DiscentiRequestMapper discenteResponseMapper;
    private  final AcademyResponseMapper academyResponseMapper;
    private final AcademyRequestMapper academyRequestMapper;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;

    @Override
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {
        Academy a = academyRequestMapper.asEntity(academyRequestDTO);
        academyRepository.save(a);
    }

    @Override
    public AcademyResponseDTO findById(Long id) {
        Academy a = academyRepository.findById(id).get();
        return academyResponseMapper.asDTO(a);
    }

    @Override
    public void deleteById(Long id) {
        Academy a = academyRepository.findById(id).get();
        academyRepository.delete(a);
    }

    @Override
    public List<AcademyResponseDTO> findAllAcademy() {
        List<Academy> academies = academyRepository.findAll();
        return academyResponseMapper.asDTOList(academies);
    }

    @Override
    public List<AcademyResponseDTO> findByNome(String nome) {
        return findByNome(nome);
    }

    @Override
    public List<AcademyResponseDTO> findByModulo(String nomeModulo) {
        return findByModulo(nomeModulo);
    }

    @Override
    public List<AcademyResponseDTO> Dettagliacademy(Long id) {
        return Dettagliacademy(id);
    }
}
