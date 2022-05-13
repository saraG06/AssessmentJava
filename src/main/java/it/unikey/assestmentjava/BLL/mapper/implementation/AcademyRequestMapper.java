package it.unikey.assestmentjava.BLL.mapper.implementation;

import it.unikey.assestmentjava.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assestmentjava.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assestmentjava.DAL.entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyRequestMapper extends GenericRequestMapper<Academy, AcademyRequestDTO> {
}
