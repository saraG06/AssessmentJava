package it.unikey.testfinale.BLL.mapper.implementation.response;

import it.unikey.testfinale.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.testfinale.BLL.mapper.dto.request.DiscenteRequestDTO;
import it.unikey.testfinale.DAL.Entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteResponseMapper extends GenericResponseMapper<Discente, DiscenteRequestDTO> {
}
