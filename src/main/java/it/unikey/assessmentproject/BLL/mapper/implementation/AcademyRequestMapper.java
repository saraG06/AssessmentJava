package it.unikey.assessmentproject.BLL.mapper.implementation;

import it.unikey.assessmentproject.BLL.DTO.request.AcademyRequestDTO;
import it.unikey.assessmentproject.BLL.mapper.absraction.GenericRequestMapper;
import it.unikey.assessmentproject.DAL.entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyRequestMapper extends GenericRequestMapper<Academy, AcademyRequestDTO> {
}
