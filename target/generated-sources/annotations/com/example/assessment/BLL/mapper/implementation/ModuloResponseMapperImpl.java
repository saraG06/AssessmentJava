package com.example.assessment.BLL.mapper.implementation;

import com.example.assessment.BLL.dto.response.ModuloResponseDTO;
import com.example.assessment.DAL.entity.Modulo;
import java.time.format.DateTimeFormatter;
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
public class ModuloResponseMapperImpl implements ModuloResponseMapper {

    @Override
    public ModuloResponseDTO asDTO(Modulo entity) {
        if ( entity == null ) {
            return null;
        }

        ModuloResponseDTO moduloResponseDTO = new ModuloResponseDTO();

        moduloResponseDTO.setId( entity.getId() );
        moduloResponseDTO.setNome( entity.getNome() );
        moduloResponseDTO.setArgomento( entity.getArgomento() );
        moduloResponseDTO.setDocente( entity.getDocente() );
        if ( entity.getDataInizio() != null ) {
            moduloResponseDTO.setDataInizio( DateTimeFormatter.ISO_LOCAL_DATE.format( entity.getDataInizio() ) );
        }
        if ( entity.getDataFine() != null ) {
            moduloResponseDTO.setDataFine( DateTimeFormatter.ISO_LOCAL_DATE.format( entity.getDataFine() ) );
        }

        return moduloResponseDTO;
    }

    @Override
    public List<ModuloResponseDTO> asDTOList(List<Modulo> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ModuloResponseDTO> list = new ArrayList<ModuloResponseDTO>( entities.size() );
        for ( Modulo modulo : entities ) {
            list.add( asDTO( modulo ) );
        }

        return list;
    }
}
