package it.unikey.assessmentproject.BLL.mapper.implementation;

import it.unikey.assessmentproject.BLL.DTO.response.ModuloResponseDTO;
import it.unikey.assessmentproject.BLL.mapper.absraction.GenericResponseMapper;
import it.unikey.assessmentproject.DAL.entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloResponseMapper extends GenericResponseMapper<Modulo, ModuloResponseDTO> {
}
