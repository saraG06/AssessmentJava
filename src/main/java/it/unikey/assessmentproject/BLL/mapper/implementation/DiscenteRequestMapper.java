package it.unikey.assessmentproject.BLL.mapper.implementation;

import it.unikey.assessmentproject.BLL.DTO.request.DiscenteRequestDTO;
import it.unikey.assessmentproject.BLL.mapper.absraction.GenericRequestMapper;
import it.unikey.assessmentproject.DAL.entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteRequestMapper extends GenericRequestMapper<Discente, DiscenteRequestDTO> {
}
