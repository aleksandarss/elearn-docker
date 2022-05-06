package com.acalic.elearndocker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="\"users\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="user_name")
    private String username;
    private Date date_joined;
    private String first_name;
    private String last_name;
    private String password;
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();
    @OneToMany(mappedBy = "teacher")
    private Set<Course> course_teach = new HashSet<>();
    @OneToMany(mappedBy = "user")
    Set<TakeCourse> take_course = new HashSet<>();
    @OneToMany(mappedBy = "user")
    Set<TakeTest> take_test = new HashSet<>();
    @OneToMany(mappedBy = "user")
    Set<DoAssignment> do_assignment = new HashSet<>();
}
