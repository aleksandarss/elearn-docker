package com.acalic.elearndocker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="\"class\"")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(columnDefinition="TEXT")
    private String text;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
