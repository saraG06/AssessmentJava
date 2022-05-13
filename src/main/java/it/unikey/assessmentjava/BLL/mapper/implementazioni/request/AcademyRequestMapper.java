package it.unikey.assessmentjava.BLL.mapper.implementazioni.request;

import it.unikey.assessmentjava.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.mapper.astratti.GenericRequestMapper;
import it.unikey.assessmentjava.DAL.Entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyRequestMapper extends GenericRequestMapper<Academy, AcademyRequestDTO> {
}
