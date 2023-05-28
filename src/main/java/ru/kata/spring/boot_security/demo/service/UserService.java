package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.dto.UserCreateUpdateDto;
import ru.kata.spring.boot_security.demo.dto.UserReadDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserReadDto> add(UserCreateUpdateDto userDto);
    Optional<UserReadDto> update(Long id, UserCreateUpdateDto userDto);
    boolean removeById(Long id);
    List<UserReadDto> findAll();
    Optional<UserReadDto> findById(Long id);
}
