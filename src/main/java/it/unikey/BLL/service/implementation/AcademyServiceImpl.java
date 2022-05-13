package it.unikey.BLL.service.implementation;

import it.unikey.BLL.dto.request.AcademyRequestDTO;
import it.unikey.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.BLL.dto.request.ModuloRequestDTO;
import it.unikey.BLL.dto.response.AcademyResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;
import it.unikey.BLL.exception.NameNotFoundException;
import it.unikey.BLL.mapper.implementation.request.AcademyRequestMapper;
import it.unikey.BLL.mapper.implementation.request.DiscenteRequestMapper;
import it.unikey.BLL.mapper.implementation.request.ModuloRequestMapper;
import it.unikey.BLL.mapper.implementation.response.AcademyResponseMapper;
import it.unikey.BLL.mapper.implementation.response.DiscenteResponseMapper;
import it.unikey.BLL.mapper.implementation.response.ModuloResponseMapper;
import it.unikey.BLL.service.abstraction.AcademyService;
import it.unikey.DAL.entity.Academy;
import it.unikey.DAL.entity.Discente;
import it.unikey.DAL.entity.Modulo;
import it.unikey.DAL.repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final ModuloRequestMapper moduloRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;
    private final ModuloResponseMapper moduloResponseMapper;

    @Override
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {
        Academy a = academyRequestMapper.asEntity(academyRequestDTO);
        a.setDiscenteList(new ArrayList<>());
        a.setModuloList(new ArrayList<>());
        for(DiscenteRequestDTO d : academyRequestDTO.getDiscenteRequestDTOList()){
            Discente discente = discenteRequestMapper.asEntity(d);
            discente.setAcademy(a);
            a.getDiscenteList().add(discente);
        }
        for(ModuloRequestDTO m : academyRequestDTO.getModuloRequestDTOList()){
            Modulo modulo = moduloRequestMapper.asEntity(m) ;
            modulo.setAcademy(a);
            a.getModuloList().add(modulo);
        }
        academyRepository.save(a);
    }

    @Override
    public AcademyResponseDTO findById(Long id) throws IdNotFoundException {
        Academy a = null;
        if (academyRepository.findById(id).isPresent()) {
            a = academyRepository.findById(id).get();
            AcademyResponseDTO aDto = academyResponseMapper.asDto(a);
            aDto.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenteList()));
            aDto.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuloList()));
            return aDto;
        }
        if(a == null){
            throw new IdNotFoundException("Id " + id + " non è presente nel db");
        }
        else {
            return academyResponseMapper.asDto(a);
        }
    }

    @Override
    public void deleteAcademy(Long id) throws IdNotFoundException {
        if(academyRepository.findById(id).isPresent()) {
            Academy a = academyRepository.findById(id).get();
            if (a != null) {
                academyRepository.delete(a);
            }
            else{
                throw new IdNotFoundException("Id " + id + " non è presente nel db");
            }
        }
    }

    @Override
    public List<AcademyResponseDTO> findByNome(String nome) throws NameNotFoundException {
        if(academyRepository.findByName(nome) != null){
            return academyResponseMapper.asDTOList(academyRepository.findByName(nome));
        }
        else
            throw new NameNotFoundException("Il nome " + nome + " non è presente nel db");
    }
    @Override
    public List<AcademyResponseDTO> findByModulo(String modulo) throws NameNotFoundException{
        if(academyRepository.findByModulo(modulo) != null){
            return academyResponseMapper.asDTOList(academyRepository.findByModulo(modulo));
        }
        else
            throw new NameNotFoundException("Il nome " + modulo + " non è presente nel db");
    }

    @Override
    public List<AcademyResponseDTO> findAllAcademy() {
        List<Academy> list = academyRepository.findAll();
        List<AcademyResponseDTO> academyResponseDTOList =  new ArrayList<>();
        for(Academy a : list){
            AcademyResponseDTO academyResponseDTO = academyResponseMapper.asDto(a);
            academyResponseDTO.setDiscenteResponseDTOList(discenteResponseMapper.asDTOList(a.getDiscenteList()));
            academyResponseDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(a.getModuloList()));
            academyResponseDTOList.add(academyResponseDTO);
        }
        return academyResponseDTOList;
    }
}
