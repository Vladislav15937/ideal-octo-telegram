package ru.kata.spring.boot_security.demo.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entity.Role;

public interface RoleRepositry extends JpaRepository<Role, Long> {
}
