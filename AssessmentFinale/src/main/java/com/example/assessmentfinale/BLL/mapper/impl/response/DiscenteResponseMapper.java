package com.example.assessmentfinale.BLL.mapper.impl.response;

import com.example.assessmentfinale.BLL.dto.response.DiscenteResponseDTO;
import com.example.assessmentfinale.BLL.mapper.abstraction.GenericResponseMapper;
import com.example.assessmentfinale.DAL.entities.Discente;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface DiscenteResponseMapper extends GenericResponseMapper<Discente, DiscenteResponseDTO>
{
}
