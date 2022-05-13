package it.unikey.assestmentjava.BLL.mapper.implementation;

import it.unikey.assestmentjava.BLL.dto.request.DocenteRequestDTO;
import it.unikey.assestmentjava.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assestmentjava.DAL.entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteRequestMapper extends GenericRequestMapper<Docente, DocenteRequestDTO> {
}
