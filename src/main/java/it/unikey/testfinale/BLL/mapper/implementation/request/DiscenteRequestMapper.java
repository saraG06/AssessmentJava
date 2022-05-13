package it.unikey.testfinale.BLL.mapper.implementation.request;

import it.unikey.testfinale.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.testfinale.BLL.mapper.dto.request.DiscenteRequestDTO;
import it.unikey.testfinale.DAL.Entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteRequestMapper extends GenericRequestMapper<Discente, DiscenteRequestDTO> {
}
