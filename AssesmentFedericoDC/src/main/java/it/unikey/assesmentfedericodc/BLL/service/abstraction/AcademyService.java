package it.unikey.assesmentfedericodc.BLL.service.abstraction;

import it.unikey.assesmentfedericodc.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.AcademyResponseDTO;

import java.util.List;

public interface AcademyService {

    void saveAcademy(AcademyRequestDTO academyRequestDTO);
    AcademyResponseDTO findById(Long id) ;
    void deleteAcademyById(Long id) ;
    List<AcademyResponseDTO> findAllAcademy();

    List<AcademyResponseDTO> findByNome(String nome);
    List<AcademyResponseDTO> findByModulo(String nomeModulo) ;
}
