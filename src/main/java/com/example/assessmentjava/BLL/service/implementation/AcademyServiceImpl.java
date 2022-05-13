package com.example.assessmentjava.BLL.service.implementation;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDto;
import com.example.assessmentjava.BLL.dto.response.AcademyResponseDto;
import com.example.assessmentjava.BLL.mapper.implementation.AcademyRequestMapper;
import com.example.assessmentjava.BLL.mapper.implementation.AcademyResponseMapper;
import com.example.assessmentjava.BLL.service.abstraction.AcademyService;
import com.example.assessmentjava.DAL.Entity.Academy;
import com.example.assessmentjava.DAL.Entity.Modulo;
import com.example.assessmentjava.DAL.Repository.AcademyRepository;
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

    @Override
    public void saveAcademy(AcademyRequestDto academyRequestDto) {
        Academy a  = academyRequestMapper.asEntity(academyRequestDto);
        academyRepository.save(a);
    }

    @Override
    public AcademyResponseDto findById(Long id) throws NullPointerException {
        Academy a =  academyRepository.getById(id);
        if (a != null) {
            academyRepository.findById(id);
        } else throw new NullPointerException();

    return academyResponseMapper.asDto(a);
    }

    @Override
        public void deleteAcademyById(Long id) throws NullPointerException{

            Academy a = academyRepository.getById(id);
            if(a!=null){
                academyRepository.deleteById(id);
            }
            else {
                throw new NullPointerException();
            }
    }

    @Override
    public List<AcademyResponseDto> findAllAcademy() {
        List<Academy> a1 = academyRepository.findAll();
        return academyResponseMapper.asDTOList(a1);
    }

    @Override
    public List<AcademyResponseDto> findAcademyByNomeIgnoreCase(String nome) {
        return academyResponseMapper.asDTOList(academyRepository.findAcademyByNomeIgnoreCase(nome));
    }

    @Override
    public List<AcademyResponseDto> findByModulo(Modulo modulo) {
        return academyResponseMapper.asDTOList(academyRepository.findByModulo(modulo));
    }

    @Override
    public AcademyResponseDto findInfo(Long id) {
        return academyResponseMapper.asDto(academyRepository.findInfo(id));
    }

    @Override
    public List<AcademyResponseDto> dataInizio(LocalDate dataInizio) {
        return academyResponseMapper.asDTOList(academyRepository.dataInizio(dataInizio));
    }

    @Override
    public List<AcademyResponseDto> dataFine(LocalDate dataFine) {
        return academyResponseMapper.asDTOList(academyRepository.dataFine(dataFine));
    }


}
