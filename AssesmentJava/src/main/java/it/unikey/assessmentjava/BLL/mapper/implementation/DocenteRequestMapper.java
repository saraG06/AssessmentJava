package it.unikey.assessmentjava.BLL.mapper.implementation;

import it.unikey.assessmentjava.BLL.DTO.request.DocenteRequestDTO;
import it.unikey.assessmentjava.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assessmentjava.DAL.entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteRequestMapper extends GenericRequestMapper<DocenteRequestDTO, Docente> {
}
