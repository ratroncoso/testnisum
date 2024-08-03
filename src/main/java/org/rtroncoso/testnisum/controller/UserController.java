package org.rtroncoso.testnisum.controller;

import org.rtroncoso.testnisum.dto.RegisterUserDTO;
import org.rtroncoso.testnisum.entity.User;
import org.rtroncoso.testnisum.exception.BadRequestException;
import org.rtroncoso.testnisum.service.UserService;
import org.rtroncoso.testnisum.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordUtils passwordUtils;

    @GetMapping("/users")
    public List<User> getUserById() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable UUID id) {
        return userService.findUserById(id);
    }

    @PostMapping(path = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody @Valid RegisterUserDTO dto) {

        if (!passwordUtils.validatePassword(dto.getPassword())) {
            throw new BadRequestException(passwordUtils.getPasswordErrorMessage());
        }
        return userService.registerNewUser(dto);
    }

    @PostMapping(path = "/users/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@PathVariable String email, String password) {
        return userService.validateLogin(email, password);
    }
}
