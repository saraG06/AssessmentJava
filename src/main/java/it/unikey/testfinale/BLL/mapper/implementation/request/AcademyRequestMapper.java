package it.unikey.testfinale.BLL.mapper.implementation.request;

import it.unikey.testfinale.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.testfinale.BLL.mapper.dto.request.AcademyRequestDTO;
import it.unikey.testfinale.DAL.Entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyRequestMapper extends GenericRequestMapper<Academy, AcademyRequestDTO> {
}
