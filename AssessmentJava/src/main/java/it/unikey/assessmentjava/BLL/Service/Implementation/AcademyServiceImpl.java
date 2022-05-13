package it.unikey.assessmentjava.BLL.Service.Implementation;

import it.unikey.assessmentjava.BLL.Dto.Request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.Mapper.Implementation.Request.AcademyRequestMapper;
import it.unikey.assessmentjava.BLL.Mapper.Implementation.Request.DiscenteRequestMapper;
import it.unikey.assessmentjava.BLL.Mapper.Implementation.Request.ModuloRequestMapper;
import it.unikey.assessmentjava.BLL.Mapper.Implementation.Response.AcademyResponseMapper;
import it.unikey.assessmentjava.BLL.Service.Abstraction.AcademyService;
import it.unikey.assessmentjava.DAL.Entity.Academy;
import it.unikey.assessmentjava.DAL.Entity.Discente;
import it.unikey.assessmentjava.DAL.Entity.Modulo;
import it.unikey.assessmentjava.DAL.Repository.AcademyRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademyServiceImpl implements AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyRequestMapper academyRequestMapper = Mappers.getMapper(AcademyRequestMapper.class);
    private final AcademyResponseMapper academyResponseMapper = Mappers.getMapper(AcademyResponseMapper.class);
    private final ModuloRequestMapper moduloRequestMapper = Mappers.getMapper(ModuloRequestMapper.class);
    private final DiscenteRequestMapper discenteRequestMapper = Mappers.getMapper(DiscenteRequestMapper.class);

    public AcademyServiceImpl(AcademyRepository academyRepository) {
        this.academyRepository = academyRepository;
    }

    @Override
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {
        Academy a = academyRequestMapper.asEntity(academyRequestDTO);
        List<Modulo> moduloList =   moduloRequestMapper.asEntityList(academyRequestDTO.getModuloRequestDTOList());
        List<Discente> discenteList = discenteRequestMapper.asEntityList(academyRequestDTO.getDiscenteRequestDTOList());
        a.setListaModuli(moduloList);
        a.setListaDiscenti(discenteList);
        academyRepository.save(a);
    }

    @Override
    public List<AcademyResponseDTO> findAll() {
       return academyResponseMapper.asDTOList(academyRepository.findAll());
    }

    @Override
    public List<AcademyResponseDTO> findAllByNomeContainingIgnoreCase(String nome) {
        return academyResponseMapper.asDTOList(academyRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @Override
    public List<AcademyResponseDTO> findAllByModulo(String modulo) {
        return academyResponseMapper.asDTOList(academyRepository.findAllByModulo(modulo));
    }

    @Override
    public List<AcademyResponseDTO> findAllWithDetails() {
        return academyResponseMapper.asDTOList(academyRepository.findAllWithDetails());
    }


}
