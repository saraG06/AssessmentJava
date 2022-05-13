package it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloResponseMapper extends GenericResponseMapper<Modulo, ModuloResponseDTO> {
}
