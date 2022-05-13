package it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request;


import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloRequestMapper extends GenericRequestMapper<Modulo, ModuloRequestDTO> {
}
