package it.unikey.assesmentfedericodc.BLL.mapper.implementation;

import it.unikey.assesmentfedericodc.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assesmentfedericodc.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.assesmentfedericodc.DAL.entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteRequestMapper extends GenericRequestMapper<Discente, DiscenteRequestDTO> {
}
