package it.unikey.assestmentjava.BLL.mapper.implementation;

import it.unikey.assestmentjava.BLL.dto.response.DocenteResponseDTO;
import it.unikey.assestmentjava.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.assestmentjava.DAL.entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteResponseMapper extends GenericResponseMapper<Docente, DocenteResponseDTO> {
}
