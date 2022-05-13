package it.unikey.assesmentfedericodc.BLL.mapper.implementation;

import it.unikey.assesmentfedericodc.BLL.dto.response.AccademyResponseDTO;
import it.unikey.assesmentfedericodc.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.assesmentfedericodc.DAL.entity.Accademy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccademyResponseMapper extends GenericResponseMapper<Accademy, AccademyResponseDTO> {
}
