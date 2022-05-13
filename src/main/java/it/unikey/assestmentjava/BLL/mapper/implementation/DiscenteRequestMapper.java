package it.unikey.assestmentjava.BLL.mapper.implementation;

import it.unikey.assestmentjava.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assestmentjava.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assestmentjava.DAL.entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteRequestMapper extends GenericRequestMapper<Discente, DiscenteRequestDTO> {
}
