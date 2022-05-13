package it.unikey.BLL.mapper.implementation.response;

import it.unikey.BLL.dto.response.DocenteResponseDTO;
import it.unikey.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.DAL.entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteResponseMapper extends GenericResponseMapper<Docente, DocenteResponseDTO> {
}
