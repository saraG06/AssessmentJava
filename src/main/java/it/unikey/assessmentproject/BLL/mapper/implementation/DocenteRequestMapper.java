package it.unikey.assessmentproject.BLL.mapper.implementation;

import it.unikey.assessmentproject.BLL.DTO.request.DocenteRequestDTO;
import it.unikey.assessmentproject.BLL.mapper.absraction.GenericRequestMapper;
import it.unikey.assessmentproject.DAL.entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteRequestMapper extends GenericRequestMapper<Docente, DocenteRequestDTO> {
}
