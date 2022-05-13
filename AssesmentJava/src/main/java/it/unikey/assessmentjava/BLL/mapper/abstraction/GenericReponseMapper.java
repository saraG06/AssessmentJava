package it.unikey.assessmentjava.BLL.mapper.abstraction;

import java.util.List;

public interface GenericReponseMapper <E,D> {

    D asDTO(E entity);

    List<D> asDTOList(List<E> entities);
}
