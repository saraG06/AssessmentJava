package com.example.assessmentjava.BLL.service.impl;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDTO;
import com.example.assessmentjava.BLL.dto.request.DiscenteRequestDTO;
import com.example.assessmentjava.BLL.dto.request.ModuloRequestDTO;
import com.example.assessmentjava.BLL.dto.response.AcademyResponseDTO;
import com.example.assessmentjava.BLL.mapper.implementation.*;
import com.example.assessmentjava.BLL.service.abstraction.AcademyService;
import com.example.assessmentjava.DAL.Entity.Academy;
import com.example.assessmentjava.DAL.Entity.Discente;
import com.example.assessmentjava.DAL.Entity.Modulo;
import com.example.assessmentjava.DAL.Repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;
    @Override
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {
        Academy a = academyRequestMapper.asEntity(academyRequestDTO);
        a.setDiscenteList(new ArrayList<>());
        a.setModuloList(new ArrayList<>());
        for(DiscenteRequestDTO d : academyRequestDTO.getDiscenteRequestDTOList()){
            Discente discente = discenteRequestMapper.asEntity(d);
            discente.setAcademy(a);
            a.getDiscenteList().add(discente);
        }
        for(ModuloRequestDTO m : academyRequestDTO.getModuloRequestDTOList()){
            Modulo modulo = moduloRequestMapper.asEntity(m) ;
            modulo.setAcademy(a);
            a.getModuloList().add(modulo);
        }
        academyRepository.save(a);
    }

    @Override
    public AcademyResponseDTO findByid(Long id) throws NullPointerException {
        Academy a = academyRepository.getById(id);
        if(a != null){
            AcademyResponseDTO academyResponseDTO = academyResponseMapper.asDTO(a);
            academyResponseDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenteList()));
            academyResponseDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuloList()));
            return academyResponseDTO;}
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
        List<AcademyResponseDTO> academyResponseDTOList =  new ArrayList<>();
        for(Academy a : list){
            AcademyResponseDTO academyResponseDTO = academyResponseMapper.asDTO(a);
            academyResponseDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenteList()));
            academyResponseDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuloList()));
            academyResponseDTOList.add(academyResponseDTO);
        }
        return academyResponseDTOList;
    }

    @Override
    public List<AcademyResponseDTO> findByName(String nome) {
        if(academyRepository.findByName(nome) != null){
            return academyResponseMapper.asDTOList(academyRepository.findByName(nome));
        }
        else
            return null;
    }

    @Override
    public List<AcademyResponseDTO> findByModulo(String modulo) throws NullPointerException{
        if(academyRepository.findByModulo(modulo) != null){
            return academyResponseMapper.asDTOList(academyRepository.findByModulo(modulo));
        }
        else
            throw new NullPointerException("Il modulo non è presente nel db");
    }


}
