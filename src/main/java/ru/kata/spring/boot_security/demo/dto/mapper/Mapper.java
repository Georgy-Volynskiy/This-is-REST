package ru.kata.spring.boot_security.demo.dto.mapper;

public interface Mapper<F, T> {

    T map (F object);

    default T map(F fromObject, T toObject) {
        return toObject;
    }
}
