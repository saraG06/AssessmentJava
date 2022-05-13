package it.unikey.assessmentjava.BLL.service.implementation;

import it.unikey.assessmentjava.BLL.DTO.request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.implementation.AcademyRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementation.AcademyResponseMapper;
import it.unikey.assessmentjava.BLL.mapper.implementation.DiscenteRequestMapper;
import it.unikey.assessmentjava.BLL.service.abstraction.AcademyService;
import it.unikey.assessmentjava.DAL.entity.Academy;
import it.unikey.assessmentjava.DAL.repository.AcademyRepository;
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
    private final DiscenteRequestMapper discenteRequestMapper;

    @Override
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {
        Academy a = academyRequestMapper.asEntity(academyRequestDTO);
        a.setDiscenti(discenteRequestMapper.asEntityList(academyRequestDTO.getDiscenteRequestDTOList()));
        academyRepository.save(a);
    }

    @Override
    public List<AcademyResponseDTO> findAllAcademy() {
        List<Academy> aList = academyRepository.findAll();
        return academyResponseMapper.asDTOList(aList);
    }

    @Override
    public AcademyResponseDTO findAcademyById(Long id) throws NullPointerException{
        Academy a = academyRepository.getById(id);
        if(id != null)
            return academyResponseMapper.asDTO(a);
        else
            throw new NullPointerException();
    }

    @Override
    public void deleteAcademyById(Long id) throws NullPointerException{
        if(academyRepository.existsById(id))
            academyRepository.deleteById(id);
        else
            throw new NullPointerException();
    }

    @Override
    public List<AcademyResponseDTO> academyConNome(String nome) {
        List<Academy> aList = academyRepository.academyConNome(nome);
        return academyResponseMapper.asDTOList(aList);
    }

    @Override
    public List<AcademyResponseDTO> academyNomeModulo(String nomemodulo) {
        List<Academy> aList = academyRepository.academyNomeModulo(nomemodulo);
        return academyResponseMapper.asDTOList(aList);
    }

    @Override
    public AcademyResponseDTO academyDetails(Long id) {
        Academy a = academyRepository.academyDetails(id);
        return academyResponseMapper.asDTO(a);
    }

    @Override
    public List<AcademyResponseDTO> startDate(LocalDate date) {
        List<Academy> aLIST = academyRepository.startDate(date);
        return academyResponseMapper.asDTOList(aLIST);
    }

    @Override
    public List<AcademyResponseDTO> endDate(LocalDate date) {
        List<Academy> aList = academyRepository.endDate(date);
        return academyResponseMapper.asDTOList(aList);
    }

    @Override
    public List<AcademyResponseDTO> betweenDate(LocalDate dateone, LocalDate datetwo) {
        List<Academy> aList = academyRepository.betweenDate(dateone, datetwo);
        return academyResponseMapper.asDTOList(aList);
    }


}
