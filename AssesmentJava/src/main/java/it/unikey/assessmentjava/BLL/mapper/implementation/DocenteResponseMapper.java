package it.unikey.assessmentjava.BLL.mapper.implementation;

import it.unikey.assessmentjava.BLL.DTO.response.DocenteResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.abstraction.GenericReponseMapper;
import it.unikey.assessmentjava.DAL.entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteResponseMapper extends GenericReponseMapper<Docente, DocenteResponseDTO> {
}
