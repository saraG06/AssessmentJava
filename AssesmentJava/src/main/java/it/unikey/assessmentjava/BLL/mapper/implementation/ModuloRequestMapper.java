package it.unikey.assessmentjava.BLL.mapper.implementation;

import it.unikey.assessmentjava.BLL.DTO.request.ModuloRequestDTO;
import it.unikey.assessmentjava.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assessmentjava.DAL.entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloRequestMapper extends GenericRequestMapper<ModuloRequestDTO, Modulo> {
}
