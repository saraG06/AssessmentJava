package it.unikey.assestmentjava.BLL.mapper.implementation;

import it.unikey.assestmentjava.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assestmentjava.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assestmentjava.DAL.entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloRequestMapper extends GenericRequestMapper<Modulo, ModuloRequestDTO> {
}
