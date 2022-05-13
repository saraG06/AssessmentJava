package it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request;


import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteRequestMapper extends GenericRequestMapper<Discente, DiscenteRequestDTO> {
}
