package it.unikey.testfinale.BLL.mapper.implementation.request;

import it.unikey.testfinale.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.testfinale.BLL.mapper.dto.request.ModuloRequestDTO;
import it.unikey.testfinale.DAL.Entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloRequestMapper extends GenericRequestMapper<Modulo, ModuloRequestDTO> {
}
