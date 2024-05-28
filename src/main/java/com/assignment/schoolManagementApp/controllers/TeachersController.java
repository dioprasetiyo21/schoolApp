package com.assignment.schoolManagementApp.controllers;

import com.assignment.schoolManagementApp.models.Search;
import com.assignment.schoolManagementApp.models.Teachers;
import com.assignment.schoolManagementApp.models.TeachersDto;
import com.assignment.schoolManagementApp.models.response.GenericRs;
import com.assignment.schoolManagementApp.repositories.TeacherRepository;
import com.assignment.schoolManagementApp.service.TeachersService;
import com.assignment.schoolManagementApp.utils.CommonUtil;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeachersController {

    private final TeacherRepository teacherRepository;
    private final TeachersService teachersService;


    @Autowired
    public TeachersController(TeacherRepository teacherRepository, TeachersService teachersService){
        this.teacherRepository = teacherRepository;
        this.teachersService = teachersService;

    }

    @PostMapping({"", "/"})
    public String searchTeacher (Model model, @ModelAttribute Search search, BindingResult result){

        if (result.hasErrors()){
            return "teachers/index";
        }

        List<Teachers> teachersList = teachersService.searchTeacher(search.getKeywoard());

        model.addAttribute("teacherList", teachersList);
        return "teachers/index";
    }

    @GetMapping({"", "/"})
    public String showTeachersList (Model model){
        List<String> teachersCount = teacherRepository.getCount();
        List<Teachers> teachersList = teachersService.getAllTeachers();
        Search search = new Search();
        model.addAttribute("count", teachersCount);
        model.addAttribute("teacherList", teachersList);
        model.addAttribute("search",search);
        return "teachers/index";
    }

    @GetMapping("/add")
    public String showAddPage(Model model){
        TeachersDto teacherDto = new TeachersDto();
        model.addAttribute("teacherDto",teacherDto);
        return "teachers/addTeacher";
    }

    @PostMapping("/add")
    public String addTeacher(@Valid @ModelAttribute TeachersDto teachersDto, BindingResult result){

        if (result.hasErrors()){
            return "teachers/addTeacher";
        }

        Teachers teacher = teachersService.addTeacher(teachersDto);
        System.out.println("==================" + teacher.getId());

        return "redirect:/teachers";
    }

    @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam int id){

        try {
            Teachers teacher = teachersService.getTeacherById(id);
            model.addAttribute("teacherDto", teacher);

        }catch (Exception ex){
            System.out.println("Exception : "+ ex.getMessage());
            return "redirect:/teachers";
        }

        return "teachers/editTeacher";
    }
    @PostMapping("/edit")
    public String editTeacher(Model model, @RequestParam int id, @Valid @ModelAttribute TeachersDto teachersDto, BindingResult result){



        try {
            if (result.hasErrors()){
                return "teachers/editTeacher";
            }

            Teachers teacher = teachersService.getTeacherById(id);
            teacher.setName(teachersDto.getName());
            teacher.setGender(teachersDto.getGender());
            teacher.setAge(teachersDto.getAge());
            teacher.setEmail(teachersDto.getEmail());
            teacher.setPhone_number(teachersDto.getPhone_number());
            Teachers res = teachersService.editTeacher(teacher,id);
            System.out.println("==================" + teacher.getId());

        }catch (Exception ex){
            System.out.println("Exception : "+ ex.getMessage());
            return "redirect:/teachers";
        }



        return "redirect:/teachers";
    }

    @GetMapping("/delete")
    public String delete(Model model, @RequestParam int id){

        try {

            teachersService.deleteTeacher(id);

        }catch (Exception ex){
            System.out.println("Exception : "+ ex.getMessage());
            return "redirect:/teachers";
        }

        return "redirect:/teachers";

    }

    /* Json */
    @GetMapping("/getall")
    public ResponseEntity<Object> getAllTeacherJSON(){
        List<Teachers> teachersList = teachersService.getAllTeachers();
        if (teachersList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        GenericRs response = CommonUtil.isSuccess(teachersList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/addTeacher")
    public ResponseEntity<Object> addTeacherJSON(@Valid @RequestBody TeachersDto teachersDto, BindingResult result){

        if (result.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Teachers teacher = teachersService.addTeacher(teachersDto);
        System.out.println("Success Insert id =" + teacher.getId());

        GenericRs response = CommonUtil.isSuccess();

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/editTeacher")
    public ResponseEntity<Object> editTeacherJSON(@RequestParam int id, @Valid @RequestBody TeachersDto teachersDto, BindingResult result){

        try {
            if (result.hasErrors()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Teachers teacher = teachersService.getTeacherById(id);
            teacher.setName(teachersDto.getName());
            teacher.setGender(teachersDto.getGender());
            teacher.setAge(teachersDto.getAge());
            teacher.setEmail(teachersDto.getEmail());
            teacher.setPhone_number(teachersDto.getPhone_number());
            Teachers res = teachersService.editTeacher(teacher,id);
            System.out.println("Success Update id " + teacher.getId());

        }catch (Exception ex){
            System.out.println("Exception : "+ ex.getMessage());
            GenericRs response = CommonUtil.isNotFound();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        GenericRs response = CommonUtil.isSuccess();

        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @PostMapping("/deleteTeacher")
    public ResponseEntity deleteJSON(@RequestParam int id){

        try {

            if (teacherRepository.existsById(id)){
                teachersService.deleteTeacher(id);
            }else{
                GenericRs response = CommonUtil.isNotFound();
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

        }catch (Exception ex){
            System.out.println("Exception : "+ ex.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        GenericRs response = CommonUtil.isSuccess();

        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);

    }

    @PostMapping("/findById")
    public ResponseEntity findByIdJSON(@RequestParam int id){
        Teachers result = new Teachers();
        try {

            result = teachersService.getTeacherById(id);


        }catch (Exception ex){
            System.out.println("Exception : "+ ex.getMessage());
            GenericRs response = CommonUtil.isNotFound();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        GenericRs response = CommonUtil.isSuccess(result);

        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);

    }
    @PostMapping("/search")
    public ResponseEntity<Object> searchTeacherJSON (@RequestParam String keywoard){

        List<Teachers> teachersList = teachersService.searchTeacher(keywoard);
        if (teachersList.isEmpty()){
            GenericRs response = CommonUtil.isNotFound();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        GenericRs response = CommonUtil.isSuccess(teachersList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
