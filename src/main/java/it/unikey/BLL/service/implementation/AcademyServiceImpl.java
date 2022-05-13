package it.unikey.BLL.service.implementation;

import it.unikey.BLL.dto.request.AcademyRequestDTO;
import it.unikey.BLL.dto.response.AcademyResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;
import it.unikey.BLL.mapper.implementation.request.AcademyRequestMapper;
import it.unikey.BLL.mapper.implementation.request.DiscenteRequestMapper;
import it.unikey.BLL.mapper.implementation.request.DocenteRequestMapper;
import it.unikey.BLL.mapper.implementation.request.ModuloRequestMapper;
import it.unikey.BLL.mapper.implementation.response.AcademyResponseMapper;
import it.unikey.BLL.service.abstraction.AcademyService;
import it.unikey.DAL.entity.Academy;
import it.unikey.DAL.entity.Discente;
import it.unikey.DAL.entity.Docente;
import it.unikey.DAL.entity.Modulo;
import it.unikey.DAL.repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;
    private final DocenteRequestMapper docenteRequestMapper;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final ModuloRequestMapper moduloRequestMapper;

    @Override
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {
        Academy a = academyRequestMapper.asEntity(academyRequestDTO);
        List<Docente> docenteList = docenteRequestMapper.asEntityList(academyRequestDTO.getDocenteRequestDTOList());
        List<Discente> discenteList = discenteRequestMapper.asEntityList(academyRequestDTO.getDiscenteRequestDTOList());
        List<Modulo> moduloList = moduloRequestMapper.asEntityList(academyRequestDTO.getModuloRequestDTOList());
        a.setDocenteList(docenteList);
        a.setDiscenteList(discenteList);
        a.setModuloList(moduloList);
        academyRepository.save(a);
    }

    @Override
    public AcademyResponseDTO findbyId(Long id) throws IdNotFoundException {
        Academy a = null;
        if (academyRepository.findById(id).isPresent()) {
            a = academyRepository.findById(id).get();
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
    public List<AcademyResponseDTO> findAllAcademy() {
        return academyResponseMapper.asDTOList(academyRepository.findAll());
    }
}
