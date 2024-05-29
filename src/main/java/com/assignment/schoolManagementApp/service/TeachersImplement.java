package com.assignment.schoolManagementApp.service;

import com.assignment.schoolManagementApp.models.Teachers;
import com.assignment.schoolManagementApp.models.TeachersDto;
import com.assignment.schoolManagementApp.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TeachersImplement implements TeachersService{

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeachersImplement (TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teachers> getAllTeachers() {
        List<Teachers> teachersList = teacherRepository.getAllTeachers();
        if (teachersList.isEmpty()){
            return null;
        }
        return teachersList;
    }

    @Override
    public Teachers addTeacher(TeachersDto teachersDto) {
        Teachers model = new Teachers();
        Teachers result =  new Teachers();
        try {
            model.setName(teachersDto.getName());
            model.setAge(teachersDto.getAge());
            model.setGender(teachersDto.getGender());
            model.setEmail(teachersDto.getEmail());
            model.setPhone_number(teachersDto.getPhone_number());
            model.setHiring_date(new Date());

            result = teacherRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public Teachers editTeacher(Teachers teachersDto, int teacherId) {
        Teachers model = new Teachers();
        Teachers result =  new Teachers();
        try {
            model.setId(teacherId);
            model.setName(teachersDto.getName());
            model.setAge(teachersDto.getAge());
            model.setGender(teachersDto.getGender());
            model.setEmail(teachersDto.getEmail());
            model.setPhone_number(teachersDto.getPhone_number());
            model.setHiring_date(teachersDto.getHiring_date());

            result = teacherRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public boolean deleteTeacher(int id) {
        Teachers model = teacherRepository.getOne(id);
        teacherRepository.delete(model);
        return true;
    }

    @Override
    public Teachers getTeacherById(int id) {
        Teachers model = teacherRepository.getOne(id);
        Teachers teacher = new Teachers();

        teacher.setId(model.getId());
        teacher.setName(model.getName());
        teacher.setGender(model.getGender());
        teacher.setAge(model.getAge());
        teacher.setEmail(model.getEmail());
        teacher.setPhone_number(model.getPhone_number());
        teacher.setHiring_date(model.getHiring_date());

        return teacher;
    }

    @Override
    public List<Teachers> searchTeacher(String keyword) {

        List<Teachers> result = teacherRepository.searchTeacher(keyword);

        return result;
    }

    @Override
    public Page<Teachers> findByPagination(int offset, int pageSize) {
        Page<Teachers> tacher = teacherRepository.findAll(PageRequest.of(offset,pageSize));
        return tacher;
    }

    @Override
    public Page<Teachers> findByPaginationAndSort(int offset, int pageSize, String field) {
        Page<Teachers> tacher = teacherRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(field)));
        return tacher;
    }
}
