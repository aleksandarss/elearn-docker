package com.acalic.elearndocker.repo;

import com.acalic.elearndocker.domain.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepo extends JpaRepository<Assignment, Long> {

}
