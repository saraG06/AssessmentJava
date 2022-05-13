package it.unikey.assestmentjava.BLL.mapper.implementation;

import it.unikey.assestmentjava.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assestmentjava.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.assestmentjava.DAL.entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyResponseMapper extends GenericResponseMapper<Academy, AcademyResponseDTO> {
}
