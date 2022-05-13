package it.unikey.assesmentfedericodc.BLL.mapper.implementation;

import it.unikey.assesmentfedericodc.BLL.dto.request.AccademyRequestDTO;
import it.unikey.assesmentfedericodc.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assesmentfedericodc.DAL.entity.Accademy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccademyRequestMapper extends GenericRequestMapper<Accademy, AccademyRequestDTO> {
}
