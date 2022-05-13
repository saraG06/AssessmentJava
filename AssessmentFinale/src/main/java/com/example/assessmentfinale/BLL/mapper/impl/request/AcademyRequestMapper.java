package com.example.assessmentfinale.BLL.mapper.impl.request;

import com.example.assessmentfinale.BLL.dto.request.AcademyRequestDTO;
import com.example.assessmentfinale.BLL.mapper.abstraction.GenericRequestMapper;
import com.example.assessmentfinale.DAL.entities.Academy;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface AcademyRequestMapper extends GenericRequestMapper <AcademyRequestDTO, Academy> {
}
