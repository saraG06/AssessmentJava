package it.unikey.assessmentproject.BLL.mapper.implementation;

import it.unikey.assessmentproject.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentproject.BLL.mapper.absraction.GenericResponseMapper;
import it.unikey.assessmentproject.DAL.entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyResponseMapper extends GenericResponseMapper<Academy, AcademyResponseDTO> {
}
