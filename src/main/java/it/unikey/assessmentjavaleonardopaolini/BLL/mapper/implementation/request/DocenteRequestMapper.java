package it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request;


import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.DocenteRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteRequestMapper extends GenericRequestMapper<Docente, DocenteRequestDTO> {
}
