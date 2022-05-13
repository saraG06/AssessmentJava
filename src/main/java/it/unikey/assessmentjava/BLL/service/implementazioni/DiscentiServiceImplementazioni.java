package it.unikey.assessmentjava.BLL.service.implementazioni;

import it.unikey.assessmentjava.BLL.dto.request.DiscentiRequestDTO;
import it.unikey.assessmentjava.BLL.dto.response.DiscentiResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.implementazioni.request.DiscentiRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementazioni.response.DiscentiResponseMapper;
import it.unikey.assessmentjava.BLL.service.astratti.DiscentiService;
import it.unikey.assessmentjava.DAL.Entity.Academy;
import it.unikey.assessmentjava.DAL.Entity.Discenti;
import it.unikey.assessmentjava.DAL.Repository.DiscentiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscentiServiceImplementazioni implements DiscentiService {

    private final DiscentiRepository discentiRepository;
    private final DiscentiRequestMapper discentiRequestMapper;
    private final DiscentiResponseMapper discentiResponseMapper;

    @Override
    public void saveDiscenti(DiscentiRequestDTO discentiRequestDTO) {
        Discenti d = discentiRequestMapper.asEntity(discentiRequestDTO);
        discentiRepository.save(d);
    }

    @Override
    public DiscentiResponseDTO findById(Long id) {
        Discenti d = discentiRepository.findById(id).get();
        return discentiResponseMapper.asDTO(d);
    }

    @Override
    public void deleteById(Long id) {
        Discenti d = discentiRepository.findById(id).get();
        discentiRepository.delete(d);
    }

    @Override
    public List<DiscentiResponseDTO> findAllDiscenti() {
        List<Discenti> discentis = discentiRepository.findAll();
        return discentiResponseMapper.asDTOList(discentis);
    }
}
