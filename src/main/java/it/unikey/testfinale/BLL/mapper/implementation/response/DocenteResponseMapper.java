package it.unikey.testfinale.BLL.mapper.implementation.response;

import it.unikey.testfinale.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.testfinale.BLL.mapper.dto.request.DocenteRequestDTO;
import it.unikey.testfinale.DAL.Entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteResponseMapper extends GenericResponseMapper<Docente, DocenteRequestDTO> {
}
