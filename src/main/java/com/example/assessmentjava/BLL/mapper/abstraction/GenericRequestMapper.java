package com.example.assessmentjava.BLL.mapper.abstraction;

import java.util.List;

public interface GenericRequestMapper <E, D> {

    E asEntity (D dto); //prendo in ingresso la DTO e la trasformo in Entity

    List<E> asEntityList (List<D> entities);

}
