package it.unikey.BLL.service.implementation;

import it.unikey.BLL.dto.request.ModuloRequestDTO;
import it.unikey.BLL.dto.response.ModuloResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;
import it.unikey.BLL.mapper.implementation.request.AcademyRequestMapper;
import it.unikey.BLL.mapper.implementation.request.ModuloRequestMapper;
import it.unikey.BLL.mapper.implementation.response.AcademyResponseMapper;
import it.unikey.BLL.mapper.implementation.response.ModuloResponseMapper;
import it.unikey.BLL.service.abstraction.ModuloService;
import it.unikey.DAL.entity.Academy;
import it.unikey.DAL.entity.Modulo;
import it.unikey.DAL.repository.ModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuloServiceImpl implements ModuloService {
    private final ModuloRepository moduloRepository;
    private final ModuloResponseMapper moduloResponseMapper;
    private final ModuloRequestMapper moduloRequestMapper;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;

    @Override
    public void saveModulo(ModuloRequestDTO moduloRequestDTO) {
        Modulo m = moduloRequestMapper.asEntity(moduloRequestDTO);
        Academy a = academyRequestMapper.asEntity(moduloRequestDTO.getAcademyRequestDTO());
        m.setAcademy(a);
        moduloRepository.save(m);
    }

    @Override
    public ModuloResponseDTO findById(Long id) throws IdNotFoundException {
        Modulo m = null;
        if (moduloRepository.findById(id).isPresent()) {
            m = moduloRepository.findById(id).get();
            ModuloResponseDTO mDTO = moduloResponseMapper.asDto(m);
            mDTO.setAcademyResponseDTO(academyResponseMapper.asDto(m.getAcademy()));
            return mDTO;
        }
        if(m == null){
            throw new IdNotFoundException("Id " + id + " non è presente nel db");
        }
        else {
            return moduloResponseMapper.asDto(m);
        }
    }

    @Override
    public void deleteModulo(Long id) throws IdNotFoundException {
        if(moduloRepository.findById(id).isPresent()) {
            Modulo m = moduloRepository.findById(id).get();
            if (m != null) {
                moduloRepository.delete(m);
            } else {
                throw new IdNotFoundException("Id " + id + " non è presente nel db");
            }
        }
    }

    @Override
    public List<ModuloResponseDTO> findAllModulo() {
        return moduloResponseMapper.asDTOList(moduloRepository.findAll());
    }
}
