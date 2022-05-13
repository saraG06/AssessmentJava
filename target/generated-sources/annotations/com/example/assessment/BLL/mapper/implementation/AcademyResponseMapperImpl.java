package com.example.assessment.BLL.mapper.implementation;

import com.example.assessment.BLL.dto.response.AcademyResponseDTO;
import com.example.assessment.DAL.entity.Academy;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-13T12:06:53+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class AcademyResponseMapperImpl implements AcademyResponseMapper {

    @Override
    public AcademyResponseDTO asDTO(Academy entity) {
        if ( entity == null ) {
            return null;
        }

        AcademyResponseDTO academyResponseDTO = new AcademyResponseDTO();

        academyResponseDTO.setId( entity.getId() );
        academyResponseDTO.setNome( entity.getNome() );
        academyResponseDTO.setDataInizio( entity.getDataInizio() );
        academyResponseDTO.setDataFine( entity.getDataFine() );

        return academyResponseDTO;
    }

    @Override
    public List<AcademyResponseDTO> asDTOList(List<Academy> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AcademyResponseDTO> list = new ArrayList<AcademyResponseDTO>( entities.size() );
        for ( Academy academy : entities ) {
            list.add( asDTO( academy ) );
        }

        return list;
    }
}
