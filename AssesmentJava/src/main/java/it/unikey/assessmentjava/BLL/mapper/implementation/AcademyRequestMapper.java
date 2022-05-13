package it.unikey.assessmentjava.BLL.mapper.implementation;

import it.unikey.assessmentjava.BLL.DTO.request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assessmentjava.DAL.entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyRequestMapper extends GenericRequestMapper<AcademyRequestDTO, Academy> {
}
