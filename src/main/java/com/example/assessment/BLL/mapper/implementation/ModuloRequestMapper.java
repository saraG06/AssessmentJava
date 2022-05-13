package com.example.assessment.BLL.mapper.implementation;

import com.example.assessment.BLL.dto.request.ModuloRequestDTO;
import com.example.assessment.BLL.mapper.abstraction.GenericRequestMapper;
import com.example.assessment.DAL.entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloRequestMapper extends GenericRequestMapper<Modulo, ModuloRequestDTO> {
}
