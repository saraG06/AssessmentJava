package it.unikey.assessmentjava.BLL.mapper.implementazioni.response;

import it.unikey.assessmentjava.BLL.dto.response.DiscentiResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.astratti.GenericResponseMapper;
import it.unikey.assessmentjava.DAL.Entity.Discenti;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscentiResponseMapper extends GenericResponseMapper<Discenti,DiscentiResponseDTO> {
}
