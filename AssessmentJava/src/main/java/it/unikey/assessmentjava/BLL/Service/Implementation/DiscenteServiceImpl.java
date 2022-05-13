package it.unikey.assessmentjava.BLL.Service.Implementation;

import it.unikey.assessmentjava.BLL.Dto.Request.DiscenteRequestDTO;
import it.unikey.assessmentjava.BLL.Mapper.Implementation.Request.DiscenteRequestMapper;
import it.unikey.assessmentjava.BLL.Service.Abstraction.DiscenteService;
import it.unikey.assessmentjava.DAL.Entity.Discente;
import it.unikey.assessmentjava.DAL.Repository.DiscenteRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class DiscenteServiceImpl implements DiscenteService {

    private final DiscenteRepository discenteRepository;
    private final DiscenteRequestMapper discenteRequestMapper = Mappers.getMapper(DiscenteRequestMapper.class);

    public DiscenteServiceImpl(DiscenteRepository discenteRepository) {
        this.discenteRepository = discenteRepository;
    }

    @Override
    public void saveDiscente(DiscenteRequestDTO discenteRequestDTO) {
        Discente d = discenteRequestMapper.asEntity(discenteRequestDTO);
        discenteRepository.save(d);
    }
}
