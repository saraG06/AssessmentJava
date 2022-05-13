package it.unikey.assessmentjava.BLL.mapper.implementazioni.response;

import it.unikey.assessmentjava.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.astratti.GenericResponseMapper;
import it.unikey.assessmentjava.DAL.Entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyResponseMapper extends GenericResponseMapper<Academy, AcademyResponseDTO> {
}
