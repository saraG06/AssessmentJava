package it.unikey.assesmentfedericodc.BLL.service.implementation;

import it.unikey.assesmentfedericodc.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.AcademyRequestMapper;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.AcademyResponseMapper;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.ModuloRequestMapper;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.ModuloResponseMapper;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.ModuloService;
import it.unikey.assesmentfedericodc.DAL.entity.Modulo;
import it.unikey.assesmentfedericodc.DAL.repository.ModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ModuloServiceImpl implements ModuloService {

    private final ModuloRepository moduloRepository;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;

    @Override
    public void saveModulo(ModuloRequestDTO moduloRequestDTO) {

        Modulo m = moduloRequestMapper.asEntity(moduloRequestDTO);
        m.setAcademy(academyRequestMapper.asEntity(moduloRequestDTO.getAcademyRequestDTO()));
        moduloRepository.save(m);

    }

    @Override
    public ModuloResponseDTO findById(Long id) {
        Modulo m = moduloRepository.findById(id).get();
        if(m!= null){
            ModuloResponseDTO mr = moduloResponseMapper.asDTO(m);
            //    mr.setAcademyResponseDTO(academyResponseMapper.asDTO(m.getAcademy()));
            return mr;
        }
        else throw new EntityNotFoundException();
    }

    @Override
    public void deleteModuloById(Long id) {
        if(moduloRepository.existsById(id))
            moduloRepository.deleteById(id);
        else throw new EntityNotFoundException();
    }

    @Override
    public List<ModuloResponseDTO> findAllModulo() {
        List<Modulo> mList = moduloRepository.findAll() ;
        List<ModuloResponseDTO> mrList =  new ArrayList<>();
        for(Modulo m : mList){
            ModuloResponseDTO cr = moduloResponseMapper.asDTO(m);
        //    cr.setAcademyResponseDTO(academyResponseMapper.asDTO(m.getAcademy()));
            mrList.add(cr);
        }
        return mrList;
    }
}
