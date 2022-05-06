package com.acalic.elearndocker.api;

import com.acalic.elearndocker.domain.Assignment;
import com.acalic.elearndocker.service.AssignmentServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "assignment")
public class AssignmentResource {

    private final AssignmentServiceImp assignmentServiceImp;

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/assignment").toUriString());
        return ResponseEntity.created(uri).body(assignmentServiceImp.saveAssignment(assignment));
    }

    @GetMapping(path = "{assignment_id}")
    public ResponseEntity<?> getAssignmentById(@PathVariable("assignment_id") Long id) {
        Assignment assignment = null;
        try {
            assignment = assignmentServiceImp.getAssignments(id);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }

        return ResponseEntity.ok().body(assignment);
    }

    @GetMapping
    public ResponseEntity<?> listAssignments() {
        return ResponseEntity.ok().body(assignmentServiceImp.getAssignments());
    }

    @DeleteMapping(path = "{assignment_id}")
    public ResponseEntity<?> deleteAssignment(@PathVariable("assignment_id") Long id) {
        try {
            assignmentServiceImp.deleteAssignment(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            if (e instanceof EntityNotFoundException) {
                return ResponseEntity.status(404).body(e.getMessage());
            }
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
