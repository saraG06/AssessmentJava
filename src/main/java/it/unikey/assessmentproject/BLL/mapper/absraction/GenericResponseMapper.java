package it.unikey.assessmentproject.BLL.mapper.absraction;

import java.util.List;

public interface GenericResponseMapper <E,D>{

    D asDTO (E entity);

    List<D> asDTOList(List<E> entities);

}

