package com.example.assessment.BLL.mapper.implementation;

import com.example.assessment.BLL.dto.request.DiscenteRequestDTO;
import com.example.assessment.BLL.mapper.abstraction.GenericRequestMapper;
import com.example.assessment.DAL.entity.Discente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscenteRequestMapper extends GenericRequestMapper<Discente, DiscenteRequestDTO> {
}
