package com.acalic.elearndocker.repo;

import com.acalic.elearndocker.domain.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepo extends JpaRepository<Class, Long> {
}
