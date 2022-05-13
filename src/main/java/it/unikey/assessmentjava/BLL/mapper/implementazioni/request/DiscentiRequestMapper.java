package it.unikey.assessmentjava.BLL.mapper.implementazioni.request;

import it.unikey.assessmentjava.BLL.dto.request.DiscentiRequestDTO;
import it.unikey.assessmentjava.BLL.mapper.astratti.GenericRequestMapper;
import it.unikey.assessmentjava.DAL.Entity.Discenti;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscentiRequestMapper extends GenericRequestMapper<Discenti,DiscentiRequestDTO>{
}
