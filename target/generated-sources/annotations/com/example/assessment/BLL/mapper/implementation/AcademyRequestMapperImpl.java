package com.example.assessment.BLL.mapper.implementation;

import com.example.assessment.BLL.dto.request.AcademyRequestDTO;
import com.example.assessment.DAL.entity.Academy;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-13T12:06:52+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class AcademyRequestMapperImpl implements AcademyRequestMapper {

    @Override
    public Academy asEntity(AcademyRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Academy academy = new Academy();

        academy.setNome( dto.getNome() );
        academy.setDataInizio( dto.getDataInizio() );
        academy.setDataFine( dto.getDataFine() );

        return academy;
    }

    @Override
    public List<Academy> asEntityList(List<AcademyRequestDTO> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Academy> list = new ArrayList<Academy>( entities.size() );
        for ( AcademyRequestDTO academyRequestDTO : entities ) {
            list.add( asEntity( academyRequestDTO ) );
        }

        return list;
    }
}
