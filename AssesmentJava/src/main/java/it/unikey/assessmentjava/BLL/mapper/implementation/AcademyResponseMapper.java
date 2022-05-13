package it.unikey.assessmentjava.BLL.mapper.implementation;

import it.unikey.assessmentjava.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.abstraction.GenericReponseMapper;
import it.unikey.assessmentjava.DAL.entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyResponseMapper extends GenericReponseMapper<Academy, AcademyResponseDTO> {
}
