package ru.kata.spring.boot_security.demo.initialization;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dto.UserCreateUpdateDto;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class InitDB {

    private final RoleService roleService;
    private final UserService userService;

    public InitDB(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    private void fillDb() {
        Role roleAdmin = roleService.add(new Role("ROLE_ADMIN"));
        Role roleUser = roleService.add(new Role("ROLE_USER"));

        UserCreateUpdateDto admin =
                new UserCreateUpdateDto("admin@mail.ru", "Ivan", "Petrov", 18, "root", Set.of(roleAdmin));
        userService.add(admin);

        UserCreateUpdateDto user =
                new UserCreateUpdateDto("user@mail.ru", "Boris", "Britva", 32, "root", Set.of(roleUser));
        userService.add(user);

        UserCreateUpdateDto userAdmin =
                new UserCreateUpdateDto("moderator@mail.ru", "Oleg", "Ivanov", 64, "root", Set.of(roleAdmin, roleUser));
        userService.add(userAdmin);
    }
}
