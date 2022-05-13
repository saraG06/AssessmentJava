package it.unikey.assessmentjava.BLL.Mapper.Implementation.Request;

import it.unikey.assessmentjava.BLL.Dto.Request.ModuloRequestDTO;
import it.unikey.assessmentjava.BLL.Mapper.Abstraction.GenericRequestMapper;
import it.unikey.assessmentjava.DAL.Entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloRequestMapper extends GenericRequestMapper<Modulo, ModuloRequestDTO> {
}
