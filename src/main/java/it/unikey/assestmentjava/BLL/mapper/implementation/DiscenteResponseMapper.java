package it.unikey.assestmentjava.BLL.mapper.implementation;

import it.unikey.assestmentjava.BLL.dto.response.DiscenteResponseDTO;
import it.unikey.assestmentjava.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.assestmentjava.DAL.entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteResponseMapper extends GenericResponseMapper<Discente, DiscenteResponseDTO> {
}
