package com.assignment.schoolManagementApp.service;

import com.assignment.schoolManagementApp.models.Teachers;
import com.assignment.schoolManagementApp.models.TeachersDto;

import java.util.List;

public interface TeachersService {

    public List<Teachers> getAllTeachers();
    public Teachers addTeacher(TeachersDto teachersDto);
    public Teachers editTeacher(Teachers teachers,int id);
    public boolean deleteTeacher(int id);
    public Teachers getTeacherById(int id);

    public List<Teachers> searchTeacher(String search);

}
