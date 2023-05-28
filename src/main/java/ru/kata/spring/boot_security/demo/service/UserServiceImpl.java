package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dto.UserCreateUpdateDto;
import ru.kata.spring.boot_security.demo.dto.UserReadDto;
import ru.kata.spring.boot_security.demo.dto.mapper.UserCreateUpdateMapper;
import ru.kata.spring.boot_security.demo.dto.mapper.UserReadMapper;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateUpdateMapper userCreateUpdateMapper;

    public UserServiceImpl(UserRepository userRepository, UserReadMapper userReadMapper, UserCreateUpdateMapper userCreateUpdateMapper) {
        this.userRepository = userRepository;
        this.userReadMapper = userReadMapper;
        this.userCreateUpdateMapper = userCreateUpdateMapper;
    }

    @Override
    @Transactional
    public Optional<UserReadDto> add(UserCreateUpdateDto userDto) {
        return Optional.ofNullable(userDto)
                .map(userCreateUpdateMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map);
    }

    @Override
    @Transactional
    public Optional<UserReadDto> update(Long id, UserCreateUpdateDto userDto) {
        return userRepository.findById(id)
                .map(entity -> userCreateUpdateMapper.map(userDto, entity))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }

    @Override
    @Transactional
    public boolean removeById(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public List<UserReadDto> findAll() {
         return userRepository.findAll().stream()
                 .map(userReadMapper::map)
                 .collect(Collectors.toList());
    }

    @Override
    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id)
                .map(userReadMapper::map);
    }
}
