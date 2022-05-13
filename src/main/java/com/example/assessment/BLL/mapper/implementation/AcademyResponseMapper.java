package com.example.assessment.BLL.mapper.implementation;

import com.example.assessment.BLL.dto.response.AcademyResponseDTO;
import com.example.assessment.BLL.mapper.abstraction.GenericResponseMapper;
import com.example.assessment.DAL.entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyResponseMapper extends GenericResponseMapper<Academy, AcademyResponseDTO> {
}
