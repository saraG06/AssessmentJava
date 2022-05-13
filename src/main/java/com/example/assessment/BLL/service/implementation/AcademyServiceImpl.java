package com.example.assessment.BLL.service.implementation;

import com.example.assessment.BLL.dto.request.AcademyRequestDTO;
import com.example.assessment.BLL.dto.response.AcademyResponseDTO;
import com.example.assessment.BLL.mapper.implementation.AcademyRequestMapper;
import com.example.assessment.BLL.mapper.implementation.AcademyResponseMapper;
import com.example.assessment.BLL.service.abstraction.AcademyService;
import com.example.assessment.DAL.entity.Academy;
import com.example.assessment.DAL.repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;

    @Override
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {
        Academy a = academyRequestMapper.asEntity(academyRequestDTO);
        academyRepository.save(a);

    }

    @Override
    public AcademyResponseDTO findAcademyById(Long id) throws NullPointerException {
        Academy a = academyRepository.getById(id);

        if (id != null) {
            return academyResponseMapper.asDTO(a);
        } else throw new NullPointerException();
    }
}
