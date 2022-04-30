package com.acalic.elearndocker.service;

import com.acalic.elearndocker.domain.Test;

import java.util.List;

public interface TestService {
    Test saveTest(Test test);
    Test getTest(Long id);
    List<Test> getTests();
    Test updateTest(Long id, String title, String text, int total_points);
    void deleteTest(Long id);
}
