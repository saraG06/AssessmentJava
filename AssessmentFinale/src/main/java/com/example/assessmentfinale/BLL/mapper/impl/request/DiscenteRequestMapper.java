package com.example.assessmentfinale.BLL.mapper.impl.request;

import com.example.assessmentfinale.BLL.dto.request.DiscenteRequestDTO;
import com.example.assessmentfinale.BLL.mapper.abstraction.GenericRequestMapper;
import com.example.assessmentfinale.DAL.entities.Discente;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface DiscenteRequestMapper extends GenericRequestMapper<DiscenteRequestDTO, Discente> {
}
