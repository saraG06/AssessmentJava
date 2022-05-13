package it.unikey.assestmentjava.BLL.service.impl;

import it.unikey.assestmentjava.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assestmentjava.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assestmentjava.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assestmentjava.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assestmentjava.BLL.mapper.implementation.AcademyRequestMapper;
import it.unikey.assestmentjava.BLL.mapper.implementation.AcademyResponseMapper;
import it.unikey.assestmentjava.BLL.mapper.implementation.DiscenteRequestMapper;
import it.unikey.assestmentjava.BLL.mapper.implementation.ModuloRequestMapper;
import it.unikey.assestmentjava.BLL.service.abstraction.AcademyService;
import it.unikey.assestmentjava.DAL.entity.Academy;
import it.unikey.assestmentjava.DAL.entity.Discente;
import it.unikey.assestmentjava.DAL.entity.Modulo;
import it.unikey.assestmentjava.DAL.repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;
    private final ModuloRequestMapper moduloRequestMapper;

    private final DiscenteRequestMapper discenteRequestMapper;


    @Override
    public void save(AcademyRequestDTO academyRequestDTO) {
        Academy a = academyRequestMapper.asEntity(academyRequestDTO);
        academyRepository.save(a);
    }

    @Override
    public AcademyResponseDTO findById(Long id) {
        Academy a = academyRepository.getById(id);
        if(a != null){
            return academyResponseMapper.asDTO(a);
        }else{
            throw new NullPointerException();
        }
    }

    @Override
    public void deleteById(Long id) {
        if(academyRepository.existsById(id)){
            academyRepository.deleteById(id);
        }else{
            throw new NullPointerException();
        }
    }

    @Override
    public List<AcademyResponseDTO> findAll() {
        List<Academy> list = academyRepository.findAll();
        return academyResponseMapper.asDTOList(list);
    }
    @Override
    public List<AcademyResponseDTO> getAcademyByNome(String nome) {
        return academyResponseMapper.asDTOList(academyRepository.getAcademyByNome(nome));
    }

    @Override
    public List<AcademyResponseDTO> getAcademyByModulo(ModuloRequestDTO moduloRequestDTO) {
        return academyResponseMapper.asDTOList(academyRepository.getAcademyByModulo(moduloRequestMapper.asEntity(moduloRequestDTO)));
    }

    @Override
    public AcademyResponseDTO getAcademyInfo(String nome){
        Academy a = academyRepository.getAcademyInfo(nome);
        List<Modulo> m = moduloRequestMapper.asEntityList((List<ModuloRequestDTO>) academyRequestMapper.asEntity((AcademyRequestDTO) a.getModuli()));
        List<Discente> d = discenteRequestMapper.asEntityList((List<DiscenteRequestDTO>) academyRequestMapper.asEntity((AcademyRequestDTO) a.getDiscenti()));
        a.setModuli(m);
        a.setDiscenti(d);
        return academyResponseMapper.asDTO(a);
    }

    @Override
    public List<AcademyResponseDTO> getAcademyByDataInizio(LocalDate datainizio) {
        return academyResponseMapper.asDTOList(academyRepository.getAcademyByDataInizio(datainizio));
    }

    @Override
    public List<AcademyResponseDTO> getAcademyByDataFine(LocalDate datafine) {
        return academyResponseMapper.asDTOList(academyRepository.getAcademyByDataFine(datafine));
    }

    @Override
    public List<AcademyResponseDTO> getAcademyByIntervalloDate(LocalDate inizio, LocalDate fine) {
        return academyResponseMapper.asDTOList(academyRepository.getAcademyByIntervalloDate(inizio, fine));
    }
}
