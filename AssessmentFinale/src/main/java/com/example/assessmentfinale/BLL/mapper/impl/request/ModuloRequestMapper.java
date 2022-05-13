package com.example.assessmentfinale.BLL.mapper.impl.request;

import com.example.assessmentfinale.BLL.dto.request.ModuloRequestDTO;
import com.example.assessmentfinale.BLL.mapper.abstraction.GenericRequestMapper;
import com.example.assessmentfinale.DAL.entities.Modulo;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ModuloRequestMapper extends GenericRequestMapper<ModuloRequestDTO, Modulo> {
}
