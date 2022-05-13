package com.example.assessment.BLL.mapper.implementation;

import com.example.assessment.BLL.dto.response.ModuloResponseDTO;
import com.example.assessment.BLL.mapper.abstraction.GenericResponseMapper;
import com.example.assessment.DAL.entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloResponseMapper extends GenericResponseMapper<Modulo, ModuloResponseDTO> {
}
