package com.acalic.elearndocker.repo;

import com.acalic.elearndocker.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}