package it.unikey.assessmentjava.BLL.mapper.implementazioni.request;

import it.unikey.assessmentjava.BLL.dto.request.DocenteRequestDTO;
import it.unikey.assessmentjava.BLL.mapper.astratti.GenericRequestMapper;
import it.unikey.assessmentjava.DAL.Entity.Docente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocentiRequestMapper extends GenericRequestMapper<Docente, DocenteRequestDTO> {
}
