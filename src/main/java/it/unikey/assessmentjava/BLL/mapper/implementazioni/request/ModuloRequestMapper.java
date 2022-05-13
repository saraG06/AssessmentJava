package it.unikey.assessmentjava.BLL.mapper.implementazioni.request;

import it.unikey.assessmentjava.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assessmentjava.BLL.mapper.astratti.GenericRequestMapper;
import it.unikey.assessmentjava.DAL.Entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloRequestMapper extends GenericRequestMapper<Modulo, ModuloRequestDTO> {
}
