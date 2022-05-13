package it.unikey.assestmentjava.BLL.service.impl;

import it.unikey.assestmentjava.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assestmentjava.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assestmentjava.BLL.mapper.implementation.AcademyRequestMapper;
import it.unikey.assestmentjava.BLL.mapper.implementation.DocenteRequestMapper;
import it.unikey.assestmentjava.BLL.mapper.implementation.ModuloRequestMapper;
import it.unikey.assestmentjava.BLL.mapper.implementation.ModuloResponseMapper;
import it.unikey.assestmentjava.BLL.service.abstraction.ModuloService;
import it.unikey.assestmentjava.DAL.entity.Academy;
import it.unikey.assestmentjava.DAL.entity.Docente;
import it.unikey.assestmentjava.DAL.entity.Modulo;
import it.unikey.assestmentjava.DAL.repository.ModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuloServiceImpl implements ModuloService {

    private final ModuloRepository moduloRepository;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;
    private final DocenteRequestMapper docenteRequestMapper;
    private final AcademyRequestMapper academyRequestMapper;

    @Override
    public void save(ModuloRequestDTO moduloRequestDTO) {
        Modulo m = moduloRequestMapper.asEntity(moduloRequestDTO);
        Docente d = docenteRequestMapper.asEntity(moduloRequestDTO.getDocenteRequestDTO());
        Academy a = academyRequestMapper.asEntity(moduloRequestDTO.getAcademyRequestDTO());
        m.setDocente(d);
        m.setAcademy(a);
        moduloRepository.save(m);
    }

    @Override
    public ModuloResponseDTO findById(Long id) {
        Modulo m = moduloRepository.getById(id);
        if(m != null){
            return moduloResponseMapper.asDTO(m);
        }else{
            throw new NullPointerException();
        }
    }

    @Override
    public void deleteById(Long id) {
        if(moduloRepository.existsById(id)){
            moduloRepository.deleteById(id);
        }else{
            throw new NullPointerException();
        }
    }

    @Override
    public List<ModuloResponseDTO> findAll() {
        List<Modulo> list = moduloRepository.findAll();
        return moduloResponseMapper.asDTOList(list);
    }
}
