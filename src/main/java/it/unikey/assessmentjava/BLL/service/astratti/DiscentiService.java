package it.unikey.assessmentjava.BLL.service.astratti;

import it.unikey.assessmentjava.BLL.dto.request.DiscentiRequestDTO;
import it.unikey.assessmentjava.BLL.dto.response.DiscentiResponseDTO;

import java.util.List;

public interface DiscentiService {
    void saveDiscenti(DiscentiRequestDTO discentiRequestDTO);
    DiscentiResponseDTO findById(Long id);
    void deleteById(Long id);
    List<DiscentiResponseDTO> findAllDiscenti();
}
