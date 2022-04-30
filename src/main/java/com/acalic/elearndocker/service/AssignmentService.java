package com.acalic.elearndocker.service;

import com.acalic.elearndocker.domain.Assignment;

import java.util.List;

public interface AssignmentService {
    Assignment saveAssignment(Assignment assignment);
    Assignment getAssignments(Long id);
    List<Assignment> getAssignments();
    Assignment updateAssignment(Long id, String text, String answer, int points);
    void deleteAssignment(Long id);
}
