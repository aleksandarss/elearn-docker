package com.acalic.elearndocker.service;

import com.acalic.elearndocker.domain.Course;
import com.acalic.elearndocker.domain.TakeCourse;
import com.acalic.elearndocker.repo.CourseRepo;
import com.acalic.elearndocker.repo.TakeCourseRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CourseServiceImp implements CourseService {
    private final CourseRepo courseRepo;
    private final TakeCourseRepo takeCourseRepo;

    @Override
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course getCourse(Long id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "course with id " + id + " does not exist"
                ));

        return course;
    }

    @Override
    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course updateCourse(Long id, String name, String description) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "course with id " + id + " does not exist"
                ));

        if (name != null &&
                    name.length() > 0 &&
                    !Objects.equals(course.getName(), name)) {
            course.setName(name);
        }

        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(course.getDescription(), description)) {
            course.setDescription(description);
        }

        return course;
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "course with id " + id + " does not exist"
                ));

        courseRepo.deleteById(id);
    }

    @Override
    public TakeCourse startCourse(TakeCourse takeCourse) {
        return takeCourseRepo.save(takeCourse);
    }


}
