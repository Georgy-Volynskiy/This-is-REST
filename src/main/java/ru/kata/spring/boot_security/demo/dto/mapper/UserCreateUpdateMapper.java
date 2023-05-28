package ru.kata.spring.boot_security.demo.dto.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.kata.spring.boot_security.demo.dto.UserCreateUpdateDto;
import ru.kata.spring.boot_security.demo.model.User;

@Component
public class UserCreateUpdateMapper implements Mapper<UserCreateUpdateDto, User> {

    private final PasswordEncoder passwordEncoder;

    public UserCreateUpdateMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User map(UserCreateUpdateDto userDto) {
        User user = new User();
        copy(userDto, user);
        return user;
    }

    @Override
    public User map(UserCreateUpdateDto userDto, User user) {
        copy(userDto, user);
        return user;
    }

    private void copy(UserCreateUpdateDto userDto, User user) {
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAge(userDto.getAge());
        user.setRoles(userDto.getRoles());
        if (StringUtils.hasText(userDto.getRawPassword())) {
            user.setPassword(passwordEncoder.encode(userDto.getRawPassword()));
        }
    }
}
