package com.acalic.elearndocker.repo;

import com.acalic.elearndocker.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
}
