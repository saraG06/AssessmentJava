package it.unikey.assessmentjava.BLL.mapper.implementation;

import it.unikey.assessmentjava.BLL.DTO.response.ModuloResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.abstraction.GenericReponseMapper;
import it.unikey.assessmentjava.DAL.entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloResponseMapper extends GenericReponseMapper<Modulo, ModuloResponseDTO> {
}
