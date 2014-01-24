package com.springapp.model;

import com.google.common.base.Objects;

public class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, grade);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return Objects.equal(this.name, other.name) && Objects.equal(this.grade, other.grade);
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}
