package it.unikey.assessmentjava.BLL.service.implementation;

import it.unikey.assessmentjava.BLL.DTO.request.ModuloRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.ModuloResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.implementation.*;
import it.unikey.assessmentjava.BLL.service.abstraction.ModuloService;
import it.unikey.assessmentjava.DAL.entity.Modulo;
import it.unikey.assessmentjava.DAL.repository.ModuloRepository;
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
    private final DiscenteRequestMapper discenteRequestMapper;

    @Override
    public void saveModulo(ModuloRequestDTO moduloRequestDTO) {
        Modulo m = moduloRequestMapper.asEntity(moduloRequestDTO);
        m.setDocente(docenteRequestMapper.asEntity(moduloRequestDTO.getDocenteRequestDTO()));
        m.setAcademy(academyRequestMapper.asEntity(moduloRequestDTO.getAcademyRequestDTO()));
        moduloRepository.save(m);
    }

    @Override
    public List<ModuloResponseDTO> findAllModulo() {
        List<Modulo> mList = moduloRepository.findAll();
        return moduloResponseMapper.asDTOList(mList);
    }

    @Override
    public ModuloResponseDTO findModuloById(Long id) throws NullPointerException{
        Modulo m = moduloRepository.getById(id);
        if(id != null)
            return moduloResponseMapper.asDTO(m);
        else
            throw new NullPointerException();
    }

    @Override
    public void deleteModuloById(Long id) throws NullPointerException{
        if(moduloRepository.existsById(id))
            moduloRepository.deleteById(id);
        else
            throw new NullPointerException();
    }
}
