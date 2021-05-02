package com.dd.covid.repository;

import java.util.Optional;

import com.dd.covid.model.jpa.ERole;
import com.dd.covid.model.jpa.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}