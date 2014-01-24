package com.springapp.controller;

import com.springapp.model.StudentModel;
import com.springapp.model.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/students")
    public String printAllStudents(ModelMap model) {
        StudentModel studentModel = new StudentModel();
        model.addAttribute("students", studentModel.getAllStudents());
        return "students";
    }

    @RequestMapping("/passedStudents")
    public String printAllPassedStudents(ModelMap model) {
        model.addAttribute("students", studentService.getAllPassedStudents());
        return "students";
    }
}
