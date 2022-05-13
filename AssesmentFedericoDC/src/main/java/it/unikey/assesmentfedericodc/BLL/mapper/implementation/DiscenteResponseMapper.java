package it.unikey.assesmentfedericodc.BLL.mapper.implementation;

import it.unikey.assesmentfedericodc.BLL.dto.response.DiscenteResponseDTO;
import it.unikey.assesmentfedericodc.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.assesmentfedericodc.DAL.entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteResponseMapper extends GenericResponseMapper<Discente, DiscenteResponseDTO> {
}
