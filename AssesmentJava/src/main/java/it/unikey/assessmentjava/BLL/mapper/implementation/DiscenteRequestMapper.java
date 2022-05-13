package it.unikey.assessmentjava.BLL.mapper.implementation;

import it.unikey.assessmentjava.BLL.DTO.request.DiscenteRequestDTO;
import it.unikey.assessmentjava.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assessmentjava.DAL.entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteRequestMapper extends GenericRequestMapper<DiscenteRequestDTO, Discente> {
}
