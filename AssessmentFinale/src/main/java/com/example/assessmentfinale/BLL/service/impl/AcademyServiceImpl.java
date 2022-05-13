package com.example.assessmentfinale.BLL.service.impl;

import com.example.assessmentfinale.BLL.dto.request.AcademyRequestDTO;
import com.example.assessmentfinale.BLL.dto.response.AcademyResponseDTO;
import com.example.assessmentfinale.BLL.mapper.impl.request.AcademyRequestMapper;
import com.example.assessmentfinale.BLL.mapper.impl.response.AcademyResponseMapper;
import com.example.assessmentfinale.BLL.service.abstraction.AcademyService;
import com.example.assessmentfinale.DAL.entities.Academy;
import com.example.assessmentfinale.DAL.repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {

    private AcademyRepository academyRepository;
    private AcademyRequestDTO academyRequestDTO;
    private AcademyResponseDTO academyResponseDTO;
    private AcademyRequestMapper academyRequestMapper;
    private AcademyResponseMapper academyResponseMapper;

    @Override //è il punto 3???
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {
        Academy a = academyRequestMapper.asEntity(academyRequestDTO);
        academyRepository.save(a);
    }

    @Override
    public List<AcademyResponseDTO> getAllAcademy() {
        List<Academy> lista = academyRepository.findAll();
        return academyResponseMapper.asDTOList(lista);
    }

    @Override
    public AcademyResponseDTO getAcademyByName(String nome) {
        Academy a = academyRepository.getAcademyByName(nome);
        return academyResponseMapper.asDTO(a);
    }
}
