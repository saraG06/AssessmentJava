package it.unikey.testfinale.BLL.mapper.implementation.response;

import it.unikey.testfinale.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.testfinale.BLL.mapper.dto.response.ModuloResponseDTO;
import it.unikey.testfinale.DAL.Entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloResponseMapper extends GenericResponseMapper<Modulo, ModuloResponseDTO> {
}
