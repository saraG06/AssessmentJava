package it.unikey.assesmentfedericodc.BLL.service.implementation;

import it.unikey.assesmentfedericodc.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.DiscenteResponseDTO;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.AccademyRequestMapper;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.AccademyResponseMapper;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.DiscenteRequestMapper;
import it.unikey.assesmentfedericodc.BLL.mapper.implementation.DiscenteResponseMapper;
import it.unikey.assesmentfedericodc.BLL.service.abstraction.DiscenteService;
import it.unikey.assesmentfedericodc.DAL.entity.Discente;
import it.unikey.assesmentfedericodc.DAL.repository.DiscenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscenteServiceImpl implements DiscenteService {

    private final DiscenteRepository discenteRepository;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;
    private  final AccademyResponseMapper accademyResponseMapper;
    private final AccademyRequestMapper accademyRequestMapper;

    @Override
    public void saveDiscente(DiscenteRequestDTO discenteRequestDTO) {
        Discente d = discenteRequestMapper.asEntity(discenteRequestDTO);
        d.setAccademy(accademyRequestMapper.asEntity(discenteRequestDTO.getAccademyRequestDTO()));
        discenteRepository.save(d);
    }

    @Override
    public DiscenteResponseDTO findById(Long id) {
        Discente d = discenteRepository.findById(id).get();
        DiscenteResponseDTO dr = discenteResponseMapper.asDTO(d);
        dr.setAccademyResponseDTO(accademyResponseMapper.asDTO(d.getAccademy()));
        return dr;
    }

    @Override
    public void deleteDiscenteById(Long id) {
        discenteRepository.deleteById(id);
    }

    @Override
    public List<DiscenteResponseDTO> findAllDiscente() {
        List<Discente> dList = discenteRepository.findAll() ;
        List<DiscenteResponseDTO> drList =  new ArrayList<>();
        for(Discente d : dList){
            DiscenteResponseDTO dr = discenteResponseMapper.asDTO(d);
            dr.setAccademyResponseDTO(accademyResponseMapper.asDTO(d.getAccademy()));
            drList.add(dr);
        }
        return drList;
    }
}
