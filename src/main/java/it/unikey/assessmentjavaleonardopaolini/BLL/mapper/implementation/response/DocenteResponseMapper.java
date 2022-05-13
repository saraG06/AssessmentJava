package it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.DocenteResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteResponseMapper extends GenericResponseMapper<Docente, DocenteResponseDTO> {
}
