package it.unikey.assessmentproject.BLL.mapper.absraction;

import java.util.List;

public interface GenericRequestMapper <E,D>{

    E asEntity (D dto); // Prendo in igresso la DTO e la trasformo in Entity

    List<E> asEntityList (List<D> Entities);

}
