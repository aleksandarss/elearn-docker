package com.acalic.elearndocker.service;

import com.acalic.elearndocker.domain.Assignment;
import com.acalic.elearndocker.repo.AssignmentRepo;
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
public class AssignmentServiceImp implements AssignmentService {
    private final AssignmentRepo assignmentRepo;


    @Override
    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepo.save(assignment);
    }

    @Override
    public Assignment getAssignments(Long id) {
        Assignment assignment = assignmentRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "assignment with id " + id + " does not exist"
                ));

        return assignment;
    }

    @Override
    public List<Assignment> getAssignments() {
        return assignmentRepo.findAll();
    }

    @Override
    @Transactional
    public Assignment updateAssignment(Long id, String text, String answer, int points) {
        Assignment assignment = assignmentRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "assignment with id " + id + " does not exist"
                ));

        if (text != null &&
                text.length() > 0 &&
                !Objects.equals(assignment.getText(), text)) {
            assignment.setText(text);
        }

        if (answer != null &&
                answer.length() > 0 &&
                !Objects.equals(assignment.getAnswer(), answer)) {
            assignment.setAnswer(answer);
        }

        if (points > 0 &&
                !Objects.equals(assignment.getPoints(), points)) {
            assignment.setPoints(points);
        }

        return assignment;
    }

    @Override
    public void deleteAssignment(Long id) {
        Assignment assignment = assignmentRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "assignment with id " + id + " does not exist"
                ));

        assignmentRepo.deleteById(id);
    }
}
