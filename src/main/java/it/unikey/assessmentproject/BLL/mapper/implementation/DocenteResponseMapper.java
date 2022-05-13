package it.unikey.assessmentproject.BLL.mapper.implementation;

import it.unikey.assessmentproject.BLL.DTO.response.DocenteResponseDTO;
import it.unikey.assessmentproject.BLL.mapper.absraction.GenericResponseMapper;
import it.unikey.assessmentproject.DAL.entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteResponseMapper extends GenericResponseMapper<Docente, DocenteResponseDTO> {
}
