package it.unikey.assessmentproject.BLL.service.implementation;

import it.unikey.assessmentproject.BLL.DTO.request.ModuloRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.ModuloResponseDTO;
import it.unikey.assessmentproject.BLL.mapper.implementation.ModuloRequestMapper;
import it.unikey.assessmentproject.BLL.mapper.implementation.ModuloResponseMapper;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;
import it.unikey.assessmentproject.BLL.service.abstraction.ModuloService;
import it.unikey.assessmentproject.DAL.repository.ModuloRepository;
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
        moduloRepository.save(moduloRequestMapper.asEntity(moduloRequestDTO));
    }

    @Override
    public ModuloResponseDTO getModuloById(Long id) throws EntityNotFoundException {
        if(moduloRepository.findById(id).get() == null){
            throw new EntityNotFoundException("L'id inserito non corrisponde a nessun modulo");
        }else return moduloResponseMapper.asDTO(moduloRepository.findById(id).get());
    }

    @Override
    public void deleteModuloById(Long id) throws EntityNotFoundException {
        if(moduloRepository.findById(id).get() == null) {
            throw new EntityNotFoundException("L'id inserito non corrisponde a nessun modulo");
        }else moduloRepository.delete(moduloRepository.findById(id).get());

    }

    @Override
    public List<ModuloResponseDTO> getAllModulo() {
        return moduloResponseMapper.asDTOList(moduloRepository.findAll());
    }
}
