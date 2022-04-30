package com.acalic.elearndocker.api;

import com.acalic.elearndocker.domain.Test;
import com.acalic.elearndocker.service.TestServiceImp;
import com.acalic.elearndocker.service.TestServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/test")
public class TestResource {
    private final TestServiceImp testServiceImp;

    @PostMapping
    public ResponseEntity<Test> createTest(@RequestBody Test test) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/test").toUriString());
        return ResponseEntity.created(uri).body(testServiceImp.saveTest(test));
    }

    @GetMapping(path = "{test_id}")
    public ResponseEntity<?> getTestById(@PathVariable("test_id") Long id) {
        Test test = null;
        try {
            test = testServiceImp.getTest(id);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }

        return ResponseEntity.ok().body(test);
    }

    @GetMapping
    public ResponseEntity<?> listTests() {
        return ResponseEntity.ok().body(testServiceImp.getTests());
    }

    @DeleteMapping(path = "{test_id}")
    public ResponseEntity<?> deleteTest(@PathVariable("test_id") Long id) {
        try {
            testServiceImp.deleteTest(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            if (e instanceof EntityNotFoundException) {
                return ResponseEntity.status(404).body(e.getMessage());
            }
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
