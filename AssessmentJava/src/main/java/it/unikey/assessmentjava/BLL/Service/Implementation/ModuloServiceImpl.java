package it.unikey.assessmentjava.BLL.Service.Implementation;

import it.unikey.assessmentjava.BLL.Dto.Request.ModuloRequestDTO;
import it.unikey.assessmentjava.BLL.Mapper.Implementation.Request.ModuloRequestMapper;
import it.unikey.assessmentjava.BLL.Service.Abstraction.ModuloService;
import it.unikey.assessmentjava.DAL.Entity.Modulo;
import it.unikey.assessmentjava.DAL.Repository.ModuloRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class ModuloServiceImpl implements ModuloService {

    private final ModuloRepository moduloRepository;
    private final ModuloRequestMapper moduloRequestMapper = Mappers.getMapper(ModuloRequestMapper.class);

    public ModuloServiceImpl(ModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
    }

    @Override
    public void saveModulo(ModuloRequestDTO moduloRequestDTO) {
        Modulo m = moduloRequestMapper.asEntity(moduloRequestDTO);
        moduloRepository.save(m);
    }
}
