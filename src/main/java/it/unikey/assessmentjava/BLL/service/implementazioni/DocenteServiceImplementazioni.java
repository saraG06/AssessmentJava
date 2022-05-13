package it.unikey.assessmentjava.BLL.service.implementazioni;

import it.unikey.assessmentjava.BLL.dto.request.DocenteRequestDTO;
import it.unikey.assessmentjava.BLL.dto.response.DocenteResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.implementazioni.request.DocentiRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementazioni.response.DocentiResponseMapper;
import it.unikey.assessmentjava.BLL.service.astratti.DocenteService;
import it.unikey.assessmentjava.DAL.Entity.Academy;
import it.unikey.assessmentjava.DAL.Entity.Docente;
import it.unikey.assessmentjava.DAL.Repository.DocenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocenteServiceImplementazioni implements DocenteService {

    private final DocenteRepository docenteRepository;
    private final DocentiRequestMapper docentiRequestMapper;
    private final DocentiResponseMapper docentiResponseMapper;

    @Override
    public void saveDocente(DocenteRequestDTO docenteRequestDTO) {
        Docente d = docentiRequestMapper.asEntity(docenteRequestDTO);
        docenteRepository.save(d);
    }

    @Override
    public DocenteResponseDTO findById(Long id) {
        Docente d = docenteRepository.findById(id).get();
        return docentiResponseMapper.asDTO(d);
    }

    @Override
    public void deleteById(Long id) {
        Docente d = docenteRepository.findById(id).get();
        docenteRepository.delete(d);
    }

    @Override
    public List<DocenteResponseDTO> findAllDocenti() {
        List<Docente> docentes = docenteRepository.findAll();
        return docentiResponseMapper.asDTOList(docentes);
    }
}
