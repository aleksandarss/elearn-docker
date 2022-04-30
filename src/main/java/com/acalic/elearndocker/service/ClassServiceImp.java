package com.acalic.elearndocker.service;

import com.acalic.elearndocker.domain.Class;
import com.acalic.elearndocker.repo.ClassRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ClassServiceImp implements ClassService {
    private final ClassRepo classRepo;

    @Override
    public Class saveClass(Class classToSave) {
        return classRepo.save(classToSave);
    }

    @Override
    public Class getClass(Long id) {
        return classRepo.getById(id);
    }

    @Override
    public List<Class> getClasses() {
        return classRepo.findAll();
    }

    @Override
    @Transactional
    public Class updateClass(Long id, String title, String text) {
        Class classToUpdate = classRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "class with id " + id + " does not exist"
                ));

        if (title != null &&
                title.length() > 0 &&
                !Objects.equals(classToUpdate.getTitle(), title)) {
            classToUpdate.setTitle(title);
        }

        if (text != null &&
                text.length() > 0 &&
                !Objects.equals(classToUpdate.getText(), text)) {
            classToUpdate.setText(text);
        }

        return classToUpdate;
    }

    @Override
    public void deleteClass(Long id) {
        Class classToDelete = classRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "class with id " + id + " does not exist"
                ));

        classRepo.deleteById(id);
    }
}
