package it.unikey.assestmentjava.BLL.mapper.implementation;

import it.unikey.assestmentjava.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assestmentjava.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.assestmentjava.DAL.entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloResponseMapper extends GenericResponseMapper<Modulo, ModuloResponseDTO> {
}
