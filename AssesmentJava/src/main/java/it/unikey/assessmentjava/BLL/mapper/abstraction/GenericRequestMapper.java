package it.unikey.assessmentjava.BLL.mapper.abstraction;

import java.util.List;

public interface GenericRequestMapper <D,E> {

    E asEntity(D dto);

    List<E> asEntityList(List<D> entities);
}
