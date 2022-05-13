package it.unikey.assessmentjava.BLL.Mapper.Implementation.Response;

import it.unikey.assessmentjava.BLL.Dto.Response.DiscenteResponseDTO;
import it.unikey.assessmentjava.BLL.Mapper.Abstraction.GenericResponseMapper;
import it.unikey.assessmentjava.DAL.Entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteResponseMapper extends GenericResponseMapper<Discente, DiscenteResponseDTO> {
}
