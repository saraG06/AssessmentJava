package it.unikey.assessmentjava.BLL.mapper.implementation;

import it.unikey.assessmentjava.BLL.DTO.response.DiscenteResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.abstraction.GenericReponseMapper;
import it.unikey.assessmentjava.DAL.entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteResponseMapper extends GenericReponseMapper<Discente, DiscenteResponseDTO> {
}
