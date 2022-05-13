package com.example.assessmentjava.BLL.mapper.implementation;

import com.example.assessmentjava.BLL.dto.response.ModuloResponseDto;
import com.example.assessmentjava.BLL.mapper.abstraction.GenericResponseMapper;
import com.example.assessmentjava.DAL.Entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloResponseMapper extends GenericResponseMapper<Modulo, ModuloResponseDto> {
}
