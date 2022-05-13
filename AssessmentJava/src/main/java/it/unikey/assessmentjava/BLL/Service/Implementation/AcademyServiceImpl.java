package it.unikey.assessmentjava.BLL.Service.Implementation;

import it.unikey.assessmentjava.BLL.Dto.Request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.Mapper.Implementation.Request.AcademyRequestMapper;
import it.unikey.assessmentjava.BLL.Mapper.Implementation.Request.DiscenteRequestMapper;
import it.unikey.assessmentjava.BLL.Mapper.Implementation.Request.ModuloRequestMapper;
import it.unikey.assessmentjava.BLL.Mapper.Implementation.Response.AcademyResponseMapper;
import it.unikey.assessmentjava.BLL.Mapper.Implementation.Response.DiscenteResponseMapper;
import it.unikey.assessmentjava.BLL.Mapper.Implementation.Response.ModuloResponseMapper;
import it.unikey.assessmentjava.BLL.Service.Abstraction.AcademyService;
import it.unikey.assessmentjava.DAL.Entity.Academy;
import it.unikey.assessmentjava.DAL.Entity.Discente;
import it.unikey.assessmentjava.DAL.Entity.Modulo;
import it.unikey.assessmentjava.DAL.Repository.AcademyRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AcademyServiceImpl implements AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyRequestMapper academyRequestMapper = Mappers.getMapper(AcademyRequestMapper.class);
    private final AcademyResponseMapper academyResponseMapper = Mappers.getMapper(AcademyResponseMapper.class);
    private final ModuloRequestMapper moduloRequestMapper = Mappers.getMapper(ModuloRequestMapper.class);
    private final DiscenteRequestMapper discenteRequestMapper = Mappers.getMapper(DiscenteRequestMapper.class);

    private final DiscenteResponseMapper discenteResponseMapper = Mappers.getMapper(DiscenteResponseMapper.class);
    private final ModuloResponseMapper moduloResponseMapper = Mappers.getMapper(ModuloResponseMapper.class);
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
        List<Academy> academyList = academyRepository.findAll();
        List<AcademyResponseDTO> academyResponseDTOList =  new ArrayList<>();
        for(Academy a : academyList){
            AcademyResponseDTO academyResponseDTO = academyResponseMapper.asDTO(a);
            academyResponseDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getListaDiscenti()));
            academyResponseDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getListaModuli()));
            academyResponseDTOList.add(academyResponseDTO);
        }
        return academyResponseDTOList;
    }

    @Override
    public List<AcademyResponseDTO> findAllByNomeContainingIgnoreCase(String nome) {
        List<Academy> academyList = academyRepository.findAllByNomeContainingIgnoreCase(nome);
        List<AcademyResponseDTO> academyResponseDTOList =  new ArrayList<>();
        for(Academy a : academyList){
            AcademyResponseDTO academyResponseDTO = academyResponseMapper.asDTO(a);
            academyResponseDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getListaDiscenti()));
            academyResponseDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getListaModuli()));
            academyResponseDTOList.add(academyResponseDTO);
        }
        return academyResponseDTOList;
    }

    @Override
    public List<AcademyResponseDTO> findAllByModulo(String modulo) {
        List<Academy> academyList = academyRepository.findAllByModulo(modulo);
        List<AcademyResponseDTO> academyResponseDTOList =  new ArrayList<>();
        for(Academy a : academyList){
            AcademyResponseDTO academyResponseDTO = academyResponseMapper.asDTO(a);
            academyResponseDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getListaDiscenti()));
            academyResponseDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getListaModuli()));
            academyResponseDTOList.add(academyResponseDTO);
        }
        return academyResponseDTOList;
    }

    @Override
    public AcademyResponseDTO findByIdWithDetails(Long id) {
        Academy a = academyRepository.findAcademyByIdWithDetails(id);

        AcademyResponseDTO academyResponseDTO = academyResponseMapper.asDTO(a);
        academyResponseDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getListaDiscenti()));
        academyResponseDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getListaModuli()));
        return academyResponseDTO;
    }

    @Override
    public List<AcademyResponseDTO> findAcademyStartAfterData(LocalDate data) {
        List<Academy> academyList = academyRepository.findAcademyStartAfterData(data);
        List<AcademyResponseDTO> academyResponseDTOList =  new ArrayList<>();
        for(Academy a : academyList){
            AcademyResponseDTO academyResponseDTO = academyResponseMapper.asDTO(a);
            academyResponseDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getListaDiscenti()));
            academyResponseDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getListaModuli()));
            academyResponseDTOList.add(academyResponseDTO);
        }
        return academyResponseDTOList;

    }

    @Override
    public List<AcademyResponseDTO> findAcademyEndBeforeData(LocalDate data) {
        List<Academy> academyList = academyRepository.findAcademyEndBeforeData(data);
        List<AcademyResponseDTO> academyResponseDTOList =  new ArrayList<>();
        for(Academy a : academyList){
            AcademyResponseDTO academyResponseDTO = academyResponseMapper.asDTO(a);
            academyResponseDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getListaDiscenti()));
            academyResponseDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getListaModuli()));
            academyResponseDTOList.add(academyResponseDTO);
        }
        return academyResponseDTOList;
    }

    @Override
    public List<AcademyResponseDTO> findAllByDataBetweenTwoDates(LocalDate data1, LocalDate data2) {
        List<Academy> academyList = academyRepository.findAllByDataInizioBetweenTwoDates(data1, data2);
        List<AcademyResponseDTO> academyResponseDTOList =  new ArrayList<>();
        for(Academy a : academyList){
            AcademyResponseDTO academyResponseDTO = academyResponseMapper.asDTO(a);
            academyResponseDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getListaDiscenti()));
            academyResponseDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getListaModuli()));
            academyResponseDTOList.add(academyResponseDTO);
        }
        return academyResponseDTOList;
    }


}
