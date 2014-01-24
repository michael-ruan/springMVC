package com.springapp.controller;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.springapp.model.Student;
import com.springapp.model.StudentModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring-mvc-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void should_get_hello_page() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }

    @Test
    public void should_get_my_name_page() throws Exception {
        mockMvc.perform(get("/name"))
                .andExpect(status().isOk())
                .andExpect(view().name("name"));
    }

    @Test
    public void should_get_students_page() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(view().name("students"));
    }

    @Test
    public void should_get_my_name() throws Exception {
        NameController nameController = new NameController();
        assertThat(nameController.getMyName(), is("RUAN Chonghe"));
    }

    @Test
    public void should_get_all_students() throws Exception {
        StudentModel studentModel = new StudentModel();
        Student studentOne = new Student("StudentOne", 50);
        Student studentTwo = new Student("StudentTwo", 60);
        Student studentThree = new Student("StudentThree", 70);
        Student studentFour = new Student("StudentFour", 80);
        Student studentFive = new Student("StudentFive", 90);
        List<Student> list = Lists.newArrayList(studentOne, studentTwo, studentThree,
                studentFour, studentFive);
        assertThat(studentModel.getAllStudents(), is(list));
        assertThat(Iterables.elementsEqual(studentModel.getAllStudents(), list), is(true));
    }

    @Test
    public void should_get_all_passed_students() throws Exception {
        StudentModel studentModel = new StudentModel();
        Student studentTwo = new Student("StudentTwo", 60);
        Student studentThree = new Student("StudentThree", 70);
        Student studentFour = new Student("StudentFour", 80);
        Student studentFive = new Student("StudentFive", 90);
        List<Student> list = Lists.newArrayList(studentTwo, studentThree,
                studentFour, studentFive);
        assertThat(Iterables.elementsEqual(studentModel.getAllPassedStudents(), list), is(true));
    }
}
