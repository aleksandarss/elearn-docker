package com.acalic.elearndocker.repo;

import com.acalic.elearndocker.domain.TakeCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TakeCourseRepo extends JpaRepository<TakeCourse, Long> {
}
