package it.unikey.assessmentjava.BLL.mapper.astratti;

import java.util.List;

public interface GenericRequestMapper<E,D> {
    E asEntity(D dto);
    List<E> asEntityList (List<D> entities);
}
