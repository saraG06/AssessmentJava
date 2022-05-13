package it.unikey.assessmentjava.BLL.service.implementazioni;

import it.unikey.assessmentjava.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assessmentjava.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.implementazioni.request.ModuloRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementazioni.response.ModuloResponseMapper;
import it.unikey.assessmentjava.BLL.service.astratti.ModuloService;
import it.unikey.assessmentjava.DAL.Entity.Academy;
import it.unikey.assessmentjava.DAL.Entity.Modulo;
import it.unikey.assessmentjava.DAL.Repository.ModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuloServiceImplementazioni implements ModuloService {

    private final ModuloRepository moduloRepository;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;

    @Override
    public void saveModulo(ModuloRequestDTO moduloRequestDTO) {
        Modulo m = moduloRequestMapper.asEntity(moduloRequestDTO);
        moduloRepository.save(m);
    }

    @Override
    public ModuloResponseDTO findById(Long id) {
        Modulo m = moduloRepository.findById(id).get();
        return moduloResponseMapper.asDTO(m);
    }

    @Override
    public void deleteById(Long id) {
        Modulo m = moduloRepository.findById(id).get();
        moduloRepository.delete(m);
    }

    @Override
    public List<ModuloResponseDTO> findAllModuli() {
        List<Modulo> modulos = moduloRepository.findAll();
        return moduloResponseMapper.asDTOList(modulos);
    }
}
