package it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.ModuloRequestDTOCreazione;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ModuloRequestMapperCreazione extends GenericRequestMapper<Modulo, ModuloRequestDTOCreazione> {
}
