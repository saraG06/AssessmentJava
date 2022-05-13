package it.unikey.assesmentfedericodc.BLL.service.implementation;

import it.unikey.assesmentfedericodc.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.DiscenteResponseDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.AccademyRequestMapper;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.AccademyResponseMapper;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.ModuloRequestMapper;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.ModuloResponseMapper;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.ModuloService;
import it.unikey.assesmentfedericodc.DAL.entity.Discente;
import it.unikey.assesmentfedericodc.DAL.entity.Modulo;
import it.unikey.assesmentfedericodc.DAL.repository.ModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ModuloServiceImpl implements ModuloService {

    private final ModuloRepository moduloRepository;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;
    private final AccademyRequestMapper accademyRequestMapper;
    private final AccademyResponseMapper accademyResponseMapper;

    @Override
    public void saveModulo(ModuloRequestDTO moduloRequestDTO) {

        Modulo m = moduloRequestMapper.asEntity(moduloRequestDTO);
        m.setAccademy(accademyRequestMapper.asEntity(moduloRequestDTO.getAccademyRequestDTO()));
        moduloRepository.save(m);

    }

    @Override
    public ModuloResponseDTO findById(Long id) {
        Modulo m = moduloRepository.findById(id).get();
        ModuloResponseDTO mr = moduloResponseMapper.asDTO(m);
        mr.setAccademyResponseDTO(accademyResponseMapper.asDTO(m.getAccademy()));
        return mr;
    }

    @Override
    public void deleteModuloById(Long id) {
        moduloRepository.deleteById(id);
    }

    @Override
    public List<ModuloResponseDTO> findAllModulo() {
        List<Modulo> mList = moduloRepository.findAll() ;
        List<ModuloResponseDTO> mrList =  new ArrayList<>();
        for(Modulo m : mList){
            ModuloResponseDTO cr = moduloResponseMapper.asDTO(m);
            cr.setAccademyResponseDTO(accademyResponseMapper.asDTO(m.getAccademy()));
            mrList.add(cr);
        }
        return mrList;
    }
}
