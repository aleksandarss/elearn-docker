package com.acalic.elearndocker.service;

import com.acalic.elearndocker.domain.Course;
import com.acalic.elearndocker.domain.Role;
import com.acalic.elearndocker.domain.TakeCourse;
import com.acalic.elearndocker.domain.User;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);
    Course getCourse(Long id);
    List<Course> getCourses();
    Course updateCourse(Long id, String name, String description);
    void deleteCourse(Long id);
    TakeCourse startCourse(TakeCourse takeCourse);
}
