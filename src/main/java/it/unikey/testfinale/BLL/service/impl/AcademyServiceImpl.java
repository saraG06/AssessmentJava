package it.unikey.testfinale.BLL.service.impl;

import it.unikey.testfinale.BLL.Exception.AlreadyExistsException;
import it.unikey.testfinale.BLL.Exception.ConflictBetweenAttributesException;
import it.unikey.testfinale.BLL.mapper.dto.request.AcademyRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.request.ModuloRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.AcademyResponseDTO;
import it.unikey.testfinale.BLL.mapper.implementation.request.AcademyRequestMapper;
import it.unikey.testfinale.BLL.mapper.implementation.request.DiscenteRequestMapper;
import it.unikey.testfinale.BLL.mapper.implementation.request.ModuloRequestMapper;
import it.unikey.testfinale.BLL.mapper.implementation.response.AcademyResponseMapper;
import it.unikey.testfinale.BLL.mapper.implementation.response.DiscenteResponseMapper;
import it.unikey.testfinale.BLL.mapper.implementation.response.ModuloResponseMapper;
import it.unikey.testfinale.BLL.service.abstraction.AcademyService;
import it.unikey.testfinale.DAL.Entity.Academy;
import it.unikey.testfinale.DAL.Repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;

    @Override
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) throws ConflictBetweenAttributesException, AlreadyExistsException {
        if(academyRequestDTO.getDataInizio().isBefore(academyRequestDTO.getDataFine())) {       //la data di inizio deve essere prima della data di fine
            Academy a = academyRequestMapper.asEntity(academyRequestDTO);
            a.setModuloList(moduloRequestMapper.asEntityList(academyRequestDTO.getModuloRequestDTOList()));
            a.setDiscenteList(discenteRequestMapper.asEntityList(academyRequestDTO.getDiscenteRequestDTOList()));
            academyRepository.save(a);
        } else
            throw new ConflictBetweenAttributesException();
    }

    @Override
    public AcademyResponseDTO findById(Long id) {
        Academy a= academyRepository.findById(id).get();
        if(a!=null){
            AcademyResponseDTO aResDTO = academyResponseMapper.asDTO(a);
            aResDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuloList()));
            aResDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenteList()));
            return aResDTO;
        }
        else
            throw new EntityNotFoundException();
    }

    @Override
    public void deleteById(Long id) {
        Academy a= academyRepository.findById(id).get();
        if(a!=null)
            academyRepository.delete(a);
        else
            throw new EntityNotFoundException();
    }

    @Override
    public List<AcademyResponseDTO> findAllAcademy() {
        List<Academy> announcementList= academyRepository.findAll();
        List<AcademyResponseDTO> academyRList= new ArrayList<>();
        for(Academy a : announcementList){
            AcademyResponseDTO aResDTO = academyResponseMapper.asDTO(a);
            aResDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuloList()));
            aResDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenteList()));
            academyRList.add(aResDTO);
        }
        return academyRList;
    }

    @Override
    public List<AcademyResponseDTO> findByNome(String nome) {
        List<Academy> announcementList= academyRepository.findByNome(nome);
        List<AcademyResponseDTO> academyRList= new ArrayList<>();
        for(Academy a : announcementList){
            AcademyResponseDTO aResDTO = academyResponseMapper.asDTO(a);
            aResDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuloList()));
            aResDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenteList()));
            academyRList.add(aResDTO);
        }
        return academyRList;
    }

    @Override
    public List<AcademyResponseDTO> findByModulo(ModuloRequestDTO moduloRequestDTO) {
        List<Academy> announcementList= academyRepository.findByModulo(moduloRequestMapper.asEntity(moduloRequestDTO));
        List<AcademyResponseDTO> academyRList= new ArrayList<>();
        for(Academy a : announcementList){
            AcademyResponseDTO aResDTO = academyResponseMapper.asDTO(a);
            aResDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuloList()));
            aResDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenteList()));
            academyRList.add(aResDTO);
        }
        return academyRList;
    }

    @Override
    public List<AcademyResponseDTO> findDetails(Long id) {
        List<Academy> announcementList= academyRepository.findDetails(id);
        List<AcademyResponseDTO> academyRList= new ArrayList<>();
        for(Academy a : announcementList){
            AcademyResponseDTO aResDTO = academyResponseMapper.asDTO(a);
            aResDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuloList()));
            aResDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenteList()));
            academyRList.add(aResDTO);
        }
        return academyRList;
    }

    @Override
    public List<AcademyResponseDTO> findByDataInizio(LocalDate dataInizio) {
        List<Academy> announcementList= academyRepository.findByDataInizio(dataInizio);
        List<AcademyResponseDTO> academyRList= new ArrayList<>();
        for(Academy a : announcementList){
            AcademyResponseDTO aResDTO = academyResponseMapper.asDTO(a);
            aResDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuloList()));
            aResDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenteList()));
            academyRList.add(aResDTO);
        }
        return academyRList;
    }

    @Override
    public List<AcademyResponseDTO> findByDataFine(LocalDate dataFine) {
        List<Academy> announcementList= academyRepository.findByDataFine(dataFine);
        List<AcademyResponseDTO> academyRList= new ArrayList<>();
        for(Academy a : announcementList){
            AcademyResponseDTO aResDTO = academyResponseMapper.asDTO(a);
            aResDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuloList()));
            aResDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenteList()));
            academyRList.add(aResDTO);
        }
        return academyRList;
    }

    @Override
    public List<AcademyResponseDTO> findByData(LocalDate dataInizio, LocalDate dataFine) {
        List<Academy> announcementList= academyRepository.findByData(dataInizio, dataFine);
        List<AcademyResponseDTO> academyRList= new ArrayList<>();
        for(Academy a : announcementList){
            AcademyResponseDTO aResDTO = academyResponseMapper.asDTO(a);
            aResDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuloList()));
            aResDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenteList()));
            academyRList.add(aResDTO);
        }
        return academyRList;
    }
}
