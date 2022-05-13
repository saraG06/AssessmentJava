package it.unikey.assesmentfedericodc.BLL.service.abstraction;

import it.unikey.assesmentfedericodc.BLL.dto.request.AccademyRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.AccademyResponseDTO;

import java.util.List;

public interface AccademyService {

    void saveAccademy(AccademyRequestDTO accademyRequestDTO);
    AccademyResponseDTO findById(Long id) ;
    void deleteAccademyById(Long id) ;
    List<AccademyResponseDTO> findAllAccademy();
}
