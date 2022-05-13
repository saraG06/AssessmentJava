package com.example.assessmentjava.BLL.mapper.implementation;

import com.example.assessmentjava.BLL.dto.response.DiscenteResponseDTO;
import com.example.assessmentjava.BLL.mapper.abstraction.GenericResponseMapper;
import com.example.assessmentjava.DAL.Entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteResponseMapper extends GenericResponseMapper<Discente, DiscenteResponseDTO> {
}
