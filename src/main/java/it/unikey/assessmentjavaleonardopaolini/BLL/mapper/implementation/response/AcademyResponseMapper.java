package it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyResponseMapper extends GenericResponseMapper<Academy, AcademyResponseDTO> {
}
