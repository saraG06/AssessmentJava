package it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response;


import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.DiscenteResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteResponseMapper extends GenericResponseMapper<Discente, DiscenteResponseDTO> {
}
