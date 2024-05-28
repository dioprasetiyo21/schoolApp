package com.assignment.schoolManagementApp.repositories;

import com.assignment.schoolManagementApp.models.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teachers, Integer> {

    @Query(value ="SELECT *  FROM teachers", nativeQuery = true)
    public List<Teachers> getAllTeachers();

    @Query(value ="SELECT COUNT(*)  FROM teachers", nativeQuery = true)
    public List<String> getCount();

    @Query(value = "SELECT * FROM teachers WHERE name LIKE %?1% OR email LIKE %?1%", nativeQuery = true)
    public List<Teachers> searchTeacher(String Keyword);
}
