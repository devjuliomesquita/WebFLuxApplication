package com.juliomesquita.application.common.interfaces;

public interface AbstractCrudMapper<T, R> {
    T toEntity(R request);
    T toEntityUpdate(T entity, R request);
    R toDto(T entity);
}
