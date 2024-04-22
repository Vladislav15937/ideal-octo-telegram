package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    private final UserService userService;

    private final RoleService roleService;

    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUserList() {
        List<User> userList = userService.show();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping(value = "/roles")
    public ResponseEntity<List<Role>> getRolesList() {
        List<Role> roleSet = roleService.getAllRoles();
        return roleSet == null && roleSet.isEmpty() ?
                new ResponseEntity<>(roleSet, HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(roleSet, HttpStatus.OK);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        final User user = userService.getUserById(id).get();
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid User user) {
        userService.save(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping(value = "/update")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid User user) {
        Long id = user.getId();
        userService.updateById(id, user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
