package it.unikey.assessmentjava.BLL.Mapper.Implementation.Request;

import it.unikey.assessmentjava.BLL.Dto.Request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.Mapper.Abstraction.GenericRequestMapper;
import it.unikey.assessmentjava.DAL.Entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyRequestMapper extends GenericRequestMapper<Academy, AcademyRequestDTO> {
}
