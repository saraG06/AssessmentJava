package com.example.assessmentjava.BLL.mapper.implementation;

import com.example.assessmentjava.BLL.dto.response.AcademyResponseDto;
import com.example.assessmentjava.BLL.mapper.abstraction.GenericResponseMapper;
import com.example.assessmentjava.DAL.Entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyResponseMapper extends GenericResponseMapper<Academy, AcademyResponseDto> {
}
