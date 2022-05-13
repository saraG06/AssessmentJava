package it.unikey.assessmentjava.BLL.mapper.implementazioni.response;

import it.unikey.assessmentjava.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.astratti.GenericResponseMapper;
import it.unikey.assessmentjava.DAL.Entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloResponseMapper extends GenericResponseMapper<Modulo, ModuloResponseDTO> {
}
