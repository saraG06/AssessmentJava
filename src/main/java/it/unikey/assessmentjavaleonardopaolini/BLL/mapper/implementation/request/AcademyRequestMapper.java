package it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyRequestMapper  extends GenericRequestMapper<Academy, AcademyRequestDTO> {
}
