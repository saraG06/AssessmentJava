package it.unikey.assestmentjava.BLL.service.impl;

import it.unikey.assestmentjava.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assestmentjava.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assestmentjava.BLL.mapper.implementation.AcademyRequestMapper;
import it.unikey.assestmentjava.BLL.mapper.implementation.AcademyResponseMapper;
import it.unikey.assestmentjava.BLL.service.abstraction.AcademyService;
import it.unikey.assestmentjava.DAL.entity.Academy;
import it.unikey.assestmentjava.DAL.repository.AcademyRepository;
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
}
