package com.acalic.elearndocker.api;

import com.acalic.elearndocker.domain.Class;
import com.acalic.elearndocker.service.ClassServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/class")
public class ClassResource {

    private final ClassServiceImp classServiceImp;

    @PostMapping
    public ResponseEntity<Class> createClass(@RequestBody Class classToCreate) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/class").toUriString());
        return ResponseEntity.created(uri).body(classServiceImp.saveClass(classToCreate));
    }

    @GetMapping(path = "{class_id}")
    public ResponseEntity<?> getClassById(@PathVariable("class_id") Long id) {
        Class classToReturn = null;
        try {
            classToReturn = classServiceImp.getClass(id);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }

        return ResponseEntity.ok().body(classToReturn);
    }

    @GetMapping
    public ResponseEntity<?> listClasses() {
        return ResponseEntity.ok().body(classServiceImp.getClasses());
    }

    @DeleteMapping(path = "{class_id}")
    public ResponseEntity<?> deleteClass(@PathVariable("class_id") Long id) {
        try {
            classServiceImp.deleteClass(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            if (e instanceof EntityNotFoundException) {
                return ResponseEntity.status(404).body(e.getMessage());
            }
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
