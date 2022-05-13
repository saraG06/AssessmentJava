package it.unikey.assessmentjava.BLL.mapper.implementazioni.response;

import it.unikey.assessmentjava.BLL.dto.response.DocenteResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.astratti.GenericResponseMapper;
import it.unikey.assessmentjava.DAL.Entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocentiResponseMapper extends GenericResponseMapper<Docente, DocenteResponseDTO> {
}
