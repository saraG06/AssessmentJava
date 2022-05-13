package it.unikey.assessmentjava.BLL.service.implementation;

import it.unikey.assessmentjava.BLL.DTO.request.ModuloRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.ModuloResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.implementation.ModuloRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementation.ModuloResponseMapper;
import it.unikey.assessmentjava.BLL.service.abstraction.ModuloService;
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

    @Override
    public void saveModulo(ModuloRequestDTO moduloRequestDTO) {

    }

    @Override
    public List<ModuloResponseDTO> findAllModulo() {
        return null;
    }

    @Override
    public ModuloResponseDTO findModuloById(Long id) {
        return null;
    }

    @Override
    public void deleteModuloById(Long id) {

    }
}
