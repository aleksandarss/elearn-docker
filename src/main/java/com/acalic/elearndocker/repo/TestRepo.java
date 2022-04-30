package com.acalic.elearndocker.repo;

import com.acalic.elearndocker.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test, Long> {
}
