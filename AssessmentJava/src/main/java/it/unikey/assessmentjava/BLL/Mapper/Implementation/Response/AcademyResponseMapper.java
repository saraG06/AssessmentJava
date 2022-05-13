package it.unikey.assessmentjava.BLL.Mapper.Implementation.Response;

import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;
import it.unikey.assessmentjava.BLL.Mapper.Abstraction.GenericResponseMapper;
import it.unikey.assessmentjava.DAL.Entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyResponseMapper extends GenericResponseMapper<Academy, AcademyResponseDTO> {
}
