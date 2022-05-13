package com.example.assessmentfinale.BLL.mapper.impl.response;

import com.example.assessmentfinale.BLL.dto.response.ModuloResponseDTO;
import com.example.assessmentfinale.BLL.mapper.abstraction.GenericResponseMapper;
import com.example.assessmentfinale.DAL.entities.Modulo;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ModuloResponseMapper extends GenericResponseMapper<Modulo, ModuloResponseDTO> {
}
