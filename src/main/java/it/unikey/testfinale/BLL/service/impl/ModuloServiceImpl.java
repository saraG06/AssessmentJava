package it.unikey.testfinale.BLL.service.impl;

import it.unikey.testfinale.BLL.Exception.ConflictBetweenAttributesException;
import it.unikey.testfinale.BLL.mapper.dto.request.ModuloRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.ModuloResponseDTO;
import it.unikey.testfinale.BLL.mapper.implementation.request.AcademyRequestMapper;
import it.unikey.testfinale.BLL.mapper.implementation.request.DocenteRequestMapper;
import it.unikey.testfinale.BLL.mapper.implementation.request.ModuloRequestMapper;
import it.unikey.testfinale.BLL.mapper.implementation.response.AcademyResponseMapper;
import it.unikey.testfinale.BLL.mapper.implementation.response.DocenteResponseMapper;
import it.unikey.testfinale.BLL.mapper.implementation.response.ModuloResponseMapper;
import it.unikey.testfinale.BLL.service.abstraction.ModuloService;
import it.unikey.testfinale.DAL.Entity.Modulo;
import it.unikey.testfinale.DAL.Repository.ModuloRepository;
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
    private final DocenteRequestMapper docenteRequestMapper;
    private final DocenteResponseMapper docenteResponseMapper;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;

    @Override
    public void saveModulo(ModuloRequestDTO moduloRequestDTO) throws ConflictBetweenAttributesException {
        if(moduloRequestDTO.getInizio().isBefore(moduloRequestDTO.getFine()) ||                                     //la data di inizio deve essere prima della data di fine
                moduloRequestDTO.getInizio().isBefore(moduloRequestDTO.getAcademyRequestDTO().getDataInizio()) ||   //il modulo non può iniziare se non è iniziata l'Academy
                moduloRequestDTO.getFine().isAfter(moduloRequestDTO.getAcademyRequestDTO().getDataFine()))          //il modulo non può finire se non è finita l'Academy
                {
            Modulo m = moduloRequestMapper.asEntity(moduloRequestDTO);
            m.setDocente(docenteRequestMapper.asEntity(moduloRequestDTO.getDocenteRequestDTO()));
            m.setAcademy(academyRequestMapper.asEntity(moduloRequestDTO.getAcademyRequestDTO()));
            moduloRepository.save(m);
        } else
            throw new ConflictBetweenAttributesException();
    }

    @Override
    public ModuloResponseDTO findById(Long id) {
        Modulo m= moduloRepository.findById(id).get();
        if(m!=null){
            ModuloResponseDTO mResDTO= moduloResponseMapper.asDTO(m);
            mResDTO.setDocenteResponseDTO(docenteResponseMapper.asDTO(m.getDocente()));
            mResDTO.setAcademyResponseDTO(academyResponseMapper.asDTO(m.getAcademy()));
            return mResDTO;
        }
        else
            throw new EntityNotFoundException();
    }

    @Override
    public void deleteById(Long id) {
        Modulo m= moduloRepository.findById(id).get();
        if(m!=null)
            moduloRepository.delete(m);
        else
            throw new EntityNotFoundException();
    }

    @Override
    public List<ModuloResponseDTO> findAllModulo() {
        List<Modulo> moduloList= moduloRepository.findAll();
        List<ModuloResponseDTO> moduloRList= new ArrayList<>();
        for(Modulo m: moduloList){
            ModuloResponseDTO mResDTO = moduloResponseMapper.asDTO(m);
            mResDTO.setDocenteResponseDTO(docenteResponseMapper.asDTO(m.getDocente()));
            mResDTO.setAcademyResponseDTO(academyResponseMapper.asDTO(m.getAcademy()));
            moduloRList.add(mResDTO);
        }
        return moduloRList;
    }
}
