package it.unikey.testfinale.BLL.mapper.implementation.request;

import it.unikey.testfinale.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.testfinale.BLL.mapper.dto.request.DocenteRequestDTO;
import it.unikey.testfinale.DAL.Entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteRequestMapper extends GenericRequestMapper<Docente, DocenteRequestDTO> {
}
