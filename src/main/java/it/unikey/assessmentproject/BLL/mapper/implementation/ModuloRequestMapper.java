package it.unikey.assessmentproject.BLL.mapper.implementation;

import it.unikey.assessmentproject.BLL.DTO.request.ModuloRequestDTO;
import it.unikey.assessmentproject.BLL.mapper.absraction.GenericRequestMapper;
import it.unikey.assessmentproject.DAL.entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloRequestMapper extends GenericRequestMapper<Modulo, ModuloRequestDTO> {
}
