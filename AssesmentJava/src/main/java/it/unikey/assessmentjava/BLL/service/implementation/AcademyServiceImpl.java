package it.unikey.assessmentjava.BLL.service.implementation;

import it.unikey.assessmentjava.BLL.DTO.request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.implementation.AcademyRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementation.AcademyResponseMapper;
import it.unikey.assessmentjava.BLL.service.abstraction.AcademyService;
import it.unikey.assessmentjava.DAL.repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;

    @Override
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {

    }

    @Override
    public List<AcademyResponseDTO> findAllAcademy() {
        return null;
    }

    @Override
    public AcademyResponseDTO findAcademyById(Long id) {
        return null;
    }

    @Override
    public void deleteAcademyById(Long id) {

    }
}
