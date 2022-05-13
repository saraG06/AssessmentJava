package com.example.assessment.BLL.mapper.implementation;

import com.example.assessment.BLL.dto.request.AcademyRequestDTO;
import com.example.assessment.BLL.mapper.abstraction.GenericRequestMapper;
import com.example.assessment.DAL.entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyRequestMapper extends GenericRequestMapper<Academy, AcademyRequestDTO> {
}
