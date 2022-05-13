package it.unikey.assesmentfedericodc.BLL.mapper.implementation;

import it.unikey.assesmentfedericodc.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assesmentfedericodc.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assesmentfedericodc.DAL.entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyRequestMapper extends GenericRequestMapper<Academy, AcademyRequestDTO> {
}
