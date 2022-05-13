package it.unikey.assestmentjava.BLL.mapper.implementation;

import it.unikey.assestmentjava.BLL.dto.response.PersonaResponseDTO;
import it.unikey.assestmentjava.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.assestmentjava.DAL.entity.Persona;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonaResponseMapper extends GenericResponseMapper<Persona, PersonaResponseDTO> {
}
