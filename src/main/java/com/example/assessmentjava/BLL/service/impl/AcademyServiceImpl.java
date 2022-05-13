package com.example.assessmentjava.BLL.service.impl;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDTO;
import com.example.assessmentjava.BLL.dto.response.AcademyResponseDTO;
import com.example.assessmentjava.BLL.mapper.implementation.AcademyRequestMapper;
import com.example.assessmentjava.BLL.mapper.implementation.AcademyResponseMapper;
import com.example.assessmentjava.BLL.mapper.implementation.DiscenteRequestMapper;
import com.example.assessmentjava.BLL.mapper.implementation.ModuloRequestMapper;
import com.example.assessmentjava.BLL.service.abstraction.AcademyService;
import com.example.assessmentjava.DAL.Entity.Academy;
import com.example.assessmentjava.DAL.Entity.Discente;
import com.example.assessmentjava.DAL.Entity.Modulo;
import com.example.assessmentjava.DAL.Repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {
        Academy a = academyRequestMapper.asEntity(academyRequestDTO);
        List<Modulo> moduloList= moduloRequestMapper.asEntityList(academyRequestDTO.getModuloRequestDTOList());
        List<Discente> discenteList= discenteRequestMapper.asEntityList(academyRequestDTO.getDiscenteRequestDTOList());
        a.setModuloList(moduloList);
        a.setDiscenteList(discenteList);

        academyRepository.save(a);
    }

    @Override
    public AcademyResponseDTO findByid(Long id) throws NullPointerException {
        Academy a = academyRepository.getById(id);
        if(a != null)
            return academyResponseMapper.asDTO(a);
        else
            throw new NullPointerException("non presente");
    }

    @Override
    public void deleteByid(Long id) throws NullPointerException {
        if(academyRepository.existsById(id)) {
            academyRepository.deleteById(id);
        }else {
            throw new NullPointerException("non presente");
        }
    }

    @Override
    public List<AcademyResponseDTO> findAllAcademy() {
        List<Academy> list = academyRepository.findAll();
        return academyResponseMapper.asDTOList(list);
    }
}
