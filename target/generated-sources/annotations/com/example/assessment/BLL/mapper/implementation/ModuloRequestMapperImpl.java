package com.example.assessment.BLL.mapper.implementation;

import com.example.assessment.BLL.dto.request.ModuloRequestDTO;
import com.example.assessment.DAL.entity.Modulo;
import java.time.LocalDate;
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
public class ModuloRequestMapperImpl implements ModuloRequestMapper {

    @Override
    public Modulo asEntity(ModuloRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Modulo modulo = new Modulo();

        modulo.setNome( dto.getNome() );
        modulo.setArgomento( dto.getArgomento() );
        modulo.setDocente( dto.getDocente() );
        if ( dto.getDataInizio() != null ) {
            modulo.setDataInizio( LocalDate.parse( dto.getDataInizio() ) );
        }
        if ( dto.getDataFine() != null ) {
            modulo.setDataFine( LocalDate.parse( dto.getDataFine() ) );
        }

        return modulo;
    }

    @Override
    public List<Modulo> asEntityList(List<ModuloRequestDTO> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Modulo> list = new ArrayList<Modulo>( entities.size() );
        for ( ModuloRequestDTO moduloRequestDTO : entities ) {
            list.add( asEntity( moduloRequestDTO ) );
        }

        return list;
    }
}
