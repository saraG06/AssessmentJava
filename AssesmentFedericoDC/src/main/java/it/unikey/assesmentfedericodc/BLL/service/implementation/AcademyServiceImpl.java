package it.unikey.assesmentfedericodc.BLL.service.implementation;

import it.unikey.assesmentfedericodc.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.*;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.AcademyService;
import it.unikey.assesmentfedericodc.DAL.entity.Academy;
import it.unikey.assesmentfedericodc.DAL.entity.Discente;
import it.unikey.assesmentfedericodc.DAL.entity.Modulo;
import it.unikey.assesmentfedericodc.DAL.repository.AcademyRepository;
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
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;
    private  final AcademyResponseMapper academyResponseMapper;
    private final AcademyRequestMapper academyRequestMapper;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;

    @Override
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {
        Academy a = academyRequestMapper.asEntity(academyRequestDTO);
//        a.setDiscenti(discenteRequestMapper.asEntityList(academyRequestDTO.getDiscenteRequestDTOList()));
//        a.setModuli(moduloRequestMapper.asEntityList(academyRequestDTO.getModuloRequestDTOList()));
        a.setDiscenti(new ArrayList<>());
        a.setModuli(new ArrayList<>());
        for(DiscenteRequestDTO d : academyRequestDTO.getDiscenteRequestDTOList()){
            Discente discente = discenteRequestMapper.asEntity(d);
            discente.setAcademy(a);
            a.getDiscenti().add(discente);
        }
        for(ModuloRequestDTO m : academyRequestDTO.getModuloRequestDTOList()){
            Modulo modulo = moduloRequestMapper.asEntity(m) ;
            modulo.setAcademy(a);
            a.getModuli().add(modulo);
        }

        academyRepository.save(a);
    }

    @Override
    public AcademyResponseDTO findById(Long id) {
        Academy a = academyRepository.findById(id).get();
        if(a != null){
            AcademyResponseDTO ar = academyResponseMapper.asDTO(a);
            ar.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenti()));
            ar.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuli()));
            return ar ;
        }else throw new EntityNotFoundException();

    }

    @Override
    public void deleteAcademyById(Long id) {
        if(academyRepository.existsById(id))
            academyRepository.deleteById(id);
        else throw new EntityNotFoundException();
    }

    @Override
    public List<AcademyResponseDTO> findAllAcademy() {
        return responseDTOListConverter(academyRepository.findAll());
    }

    @Override
    public List<AcademyResponseDTO> findByNome(String nome) {
        return responseDTOListConverter(academyRepository.findByNome(nome));
    }

    @Override
    public List<AcademyResponseDTO> findByModulo(String nomeModulo) {
        return responseDTOListConverter(academyRepository.findByModulo(nomeModulo));
    }

    @Override
    public List<AcademyResponseDTO> findByDataIniziaDopo(LocalDate data) {
        return responseDTOListConverter(academyRepository.findByDataIniziaDopo(data));
    }

    @Override
    public List<AcademyResponseDTO> findByDataFiniscePrima(LocalDate data) {
        return responseDTOListConverter(academyRepository.findByDataFiniscePrima(data));
    }

    @Override
    public List<AcademyResponseDTO> findByDataCompresa(LocalDate dataMin, LocalDate dataMax) {
        return responseDTOListConverter(academyRepository.findByDataCompresa(dataMin,dataMax));
    }

    //questo metodo mi serve per convertire una lista academy in una di responsedto
    //la uso in tutti i metodi in cui devo tornare una lista di responsedto
    private List<AcademyResponseDTO> responseDTOListConverter(List<Academy> cList){
        List<AcademyResponseDTO> arList =  new ArrayList<>();
        for(Academy a : cList){
            AcademyResponseDTO ar = academyResponseMapper.asDTO(a);
            ar.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenti()));
            ar.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuli()));
            arList.add(ar);
        }
        return arList;
    }
}
