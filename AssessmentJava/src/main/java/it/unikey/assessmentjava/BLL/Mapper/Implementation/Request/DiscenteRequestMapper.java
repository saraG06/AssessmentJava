package it.unikey.assessmentjava.BLL.Mapper.Implementation.Request;

import it.unikey.assessmentjava.BLL.Dto.Request.DiscenteRequestDTO;
import it.unikey.assessmentjava.BLL.Mapper.Abstraction.GenericRequestMapper;
import it.unikey.assessmentjava.DAL.Entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteRequestMapper extends GenericRequestMapper<Discente, DiscenteRequestDTO> {
}
