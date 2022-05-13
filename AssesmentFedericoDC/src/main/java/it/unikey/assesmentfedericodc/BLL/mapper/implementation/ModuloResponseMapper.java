package it.unikey.assesmentfedericodc.BLL.mapper.implementation;

import it.unikey.assesmentfedericodc.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assesmentfedericodc.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.assesmentfedericodc.DAL.entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloResponseMapper extends GenericResponseMapper<Modulo, ModuloResponseDTO> {
}
