package com.example.assessment.BLL.mapper.implementation;

import com.example.assessment.BLL.dto.response.DiscenteResponseDTO;
import com.example.assessment.BLL.mapper.abstraction.GenericResponseMapper;
import com.example.assessment.DAL.entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteResponseMapper extends GenericResponseMapper<Discente, DiscenteResponseDTO> {
}
