package it.unikey.assessmentjava.BLL.Mapper.Implementation.Response;

import it.unikey.assessmentjava.BLL.Dto.Response.ModuloResponseDTO;
import it.unikey.assessmentjava.BLL.Mapper.Abstraction.GenericResponseMapper;
import it.unikey.assessmentjava.DAL.Entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloResponseMapper extends GenericResponseMapper<Modulo, ModuloResponseDTO> {
}
