package com.example.assessment.BLL.mapper.implementation;

import com.example.assessment.BLL.dto.response.DiscenteResponseDTO;
import com.example.assessment.DAL.entity.Discente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-13T16:03:05+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class DiscenteResponseMapperImpl implements DiscenteResponseMapper {

    @Override
    public DiscenteResponseDTO asDTO(Discente entity) {
        if ( entity == null ) {
            return null;
        }

        DiscenteResponseDTO discenteResponseDTO = new DiscenteResponseDTO();

        discenteResponseDTO.setId( entity.getId() );
        discenteResponseDTO.setNome( entity.getNome() );
        discenteResponseDTO.setCognome( entity.getCognome() );
        discenteResponseDTO.setCodiceFiscale( entity.getCodiceFiscale() );

        return discenteResponseDTO;
    }

    @Override
    public List<DiscenteResponseDTO> asDTOList(List<Discente> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DiscenteResponseDTO> list = new ArrayList<DiscenteResponseDTO>( entities.size() );
        for ( Discente discente : entities ) {
            list.add( asDTO( discente ) );
        }

        return list;
    }
}
