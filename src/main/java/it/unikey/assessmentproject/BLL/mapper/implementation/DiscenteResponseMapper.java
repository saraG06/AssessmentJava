package it.unikey.assessmentproject.BLL.mapper.implementation;

import it.unikey.assessmentproject.BLL.DTO.response.DiscenteResponseDTO;
import it.unikey.assessmentproject.BLL.mapper.absraction.GenericResponseMapper;
import it.unikey.assessmentproject.DAL.entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteResponseMapper extends GenericResponseMapper<Discente, DiscenteResponseDTO> {
}
