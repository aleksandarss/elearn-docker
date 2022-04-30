package com.acalic.elearndocker.service;

import com.acalic.elearndocker.domain.Test;
import com.acalic.elearndocker.repo.TestRepo;
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
public class TestServiceImp implements TestService {
    private final TestRepo testRepo;

    @Override
    public Test saveTest(Test test) {
        return testRepo.save(test);
    }

    @Override
    public Test getTest(Long id) {
        Test test = testRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "test with id " + id + " does not exist"
                ));

        return testRepo.getById(id);
    }

    @Override
    public List<Test> getTests() {
        return testRepo.findAll();
    }

    @Override
    public Test updateTest(Long id, String title, String text, int total_points) {
        Test test = testRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "test with id " + id + " does not exist"
                ));

        if (title != null &&
                title.length() > 0 &&
                !Objects.equals(test.getTitle(), title)) {
            test.setTitle(title);
        }

        if (text != null &&
                text.length() > 0 &&
                !Objects.equals(test.getText(), text)) {
            test.setText(text);
        }

        if (total_points > 0 &&
                !Objects.equals(test.getTotal_points(), total_points)) {
            test.setTotal_points(total_points);
        }

        return test;
    }

    @Override
    public void deleteTest(Long id) {
        Test test = testRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "test with id " + id + " does not exist"
                ));

        testRepo.deleteById(id);
    }
}
