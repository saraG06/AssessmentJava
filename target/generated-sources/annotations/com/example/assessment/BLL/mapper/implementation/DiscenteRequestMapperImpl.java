package com.example.assessment.BLL.mapper.implementation;

import com.example.assessment.BLL.dto.request.DiscenteRequestDTO;
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
public class DiscenteRequestMapperImpl implements DiscenteRequestMapper {

    @Override
    public Discente asEntity(DiscenteRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Discente discente = new Discente();

        discente.setNome( dto.getNome() );
        discente.setCognome( dto.getCognome() );
        discente.setCodiceFiscale( dto.getCodiceFiscale() );

        return discente;
    }

    @Override
    public List<Discente> asEntityList(List<DiscenteRequestDTO> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Discente> list = new ArrayList<Discente>( entities.size() );
        for ( DiscenteRequestDTO discenteRequestDTO : entities ) {
            list.add( asEntity( discenteRequestDTO ) );
        }

        return list;
    }
}
