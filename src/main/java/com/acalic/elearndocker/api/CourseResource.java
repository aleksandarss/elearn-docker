package com.acalic.elearndocker.api;

import com.acalic.elearndocker.domain.Course;
import com.acalic.elearndocker.service.CourseServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/course")
public class CourseResource {
    private final CourseServiceImp courseServiceImp;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/course").toUriString());
        return ResponseEntity.created(uri).body(courseServiceImp.saveCourse(course));
    }

    @GetMapping(path = "{course_id}")
    public ResponseEntity<?> getCourseById(@PathVariable("course_id") Long id) {
        Course course = null;
        try {
            course = courseServiceImp.getCourse(id);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }

        return ResponseEntity.ok().body(course);
    }

    @GetMapping
    public ResponseEntity<?> listCourses() {
        return ResponseEntity.ok().body(courseServiceImp.getCourses());
    }

    @DeleteMapping(path = "{course_id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("course_id") Long id) {
        try {
            courseServiceImp.deleteCourse(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            if (e instanceof EntityNotFoundException) {
                return ResponseEntity.status(404).body(e.getMessage());
            }
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
