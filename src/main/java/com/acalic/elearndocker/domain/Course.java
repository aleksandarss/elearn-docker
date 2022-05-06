package com.acalic.elearndocker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="\"courses\"")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(columnDefinition="TEXT")
    private String description;
    @OneToMany(mappedBy = "course")
    private Set<Test> tests = new HashSet<>();
    @OneToMany(mappedBy = "course")
    private Set<Class> classes = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;
    @OneToMany(mappedBy = "course")
    Set<TakeCourse> take_course = new HashSet<>();
}
