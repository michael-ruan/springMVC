package com.springapp.model;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;

public class StudentModel implements StudentService{
    public static final int PASSED_GRADE = 60;
    Student studentOne = new Student("StudentOne", 50);
    Student studentTwo = new Student("StudentTwo", 60);
    Student studentThree = new Student("StudentThree", 70);
    Student studentFour = new Student("StudentFour", 80);
    Student studentFive = new Student("StudentFive", 90);
    private List<Student> list = Lists.newArrayList(studentOne, studentTwo, studentThree,
            studentFour, studentFive);

    @Override
    public List<Student> getAllStudents() {
        return list;
    }

    @Override
    public List<Student> getAllPassedStudents() {
        ImmutableList<Student> passedStudents = ImmutableList.copyOf(Iterables.filter(
                list, new Predicate<Student>() {
            @Override
            public boolean apply(Student student) {
                return student.getGrade() >= PASSED_GRADE;
            }
        }
        ));
        return passedStudents;
    }
}
