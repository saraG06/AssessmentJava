package it.unikey.BLL.mapper.implementation.request;

import it.unikey.BLL.dto.request.DocenteRequestDTO;
import it.unikey.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.DAL.entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteRequestMapper extends GenericRequestMapper<Docente, DocenteRequestDTO> {
}
