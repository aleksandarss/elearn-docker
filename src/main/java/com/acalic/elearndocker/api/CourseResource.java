package com.acalic.elearndocker.api;

import com.acalic.elearndocker.domain.Course;
import com.acalic.elearndocker.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseResource {
    private final CourseService courseService;

    @PostMapping("/course")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/course/save").toUriString());
        return ResponseEntity.created(uri).body(courseService.saveCourse(course));
    }
}
