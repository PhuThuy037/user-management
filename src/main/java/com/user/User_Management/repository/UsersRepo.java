package com.user.User_Management.repository;

import com.user.User_Management.entity.OurUsers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<OurUsers, Long> {

    Optional<OurUsers> findByEmail(String email);
}
