package com.example.assessmentjava.BLL.mapper.implementation;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDto;
import com.example.assessmentjava.BLL.mapper.abstraction.GenericRequestMapper;
import com.example.assessmentjava.DAL.Entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyRequestMapper extends GenericRequestMapper<AcademyRequestDto, Academy> {
}
