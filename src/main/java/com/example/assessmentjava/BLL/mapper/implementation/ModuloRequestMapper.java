package com.example.assessmentjava.BLL.mapper.implementation;

import com.example.assessmentjava.BLL.dto.request.ModuloRequestDto;
import com.example.assessmentjava.BLL.mapper.abstraction.GenericRequestMapper;
import com.example.assessmentjava.DAL.Entity.Modulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuloRequestMapper extends GenericRequestMapper<ModuloRequestDto, Modulo> {
}
