package com.example.assessmentfinale.BLL.mapper.impl.response;

import com.example.assessmentfinale.BLL.dto.response.AcademyResponseDTO;
import com.example.assessmentfinale.BLL.mapper.abstraction.GenericResponseMapper;
import com.example.assessmentfinale.DAL.entities.Academy;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface AcademyResponseMapper extends GenericResponseMapper<Academy, AcademyResponseDTO> {
}
