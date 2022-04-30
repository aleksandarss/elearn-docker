package com.acalic.elearndocker.service;

import com.acalic.elearndocker.domain.Class;

import java.util.List;

public interface ClassService {
    Class saveClass(Class classToSave);
    Class getClass(Long id);
    List<Class> getClasses();
    Class updateClass(Long id, String title, String text);
    void deleteClass(Long id);
}
