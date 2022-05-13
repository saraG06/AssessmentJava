package it.unikey.assestmentjava.BLL.mapper.implementation;

import it.unikey.assestmentjava.BLL.dto.request.PersonaRequestDTO;
import it.unikey.assestmentjava.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assestmentjava.DAL.entity.Persona;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonaRequestMapper extends GenericRequestMapper<Persona, PersonaRequestDTO> {
}
