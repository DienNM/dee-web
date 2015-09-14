package com.dee.web.sample01.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dee.web.sample01.dto.StudentData;
import com.dee.web.sample01.enumeration.Gender;
import com.dee.web.sample01.service.StudentService;

/**
 * @author dien.nguyen
 **/

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @ModelAttribute("genders")
    public List<Gender> genders() {
        return Arrays.asList(Gender.values());
    }

    @RequestMapping(method = RequestMethod.GET)
    public String displayStudents(Model model) {
        List<StudentData> students = studentService.getAll();
        model.addAttribute("results", students);

        return "student_list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getStudentDetail(@PathVariable(value = "id") String id, Model model, RedirectAttributes redirectAtts) {
        StudentData studentData = studentService.get(id);
        if (studentData == null) {
            redirectAtts.addFlashAttribute("error", String.format("Student Id: %s not found", id));
            return "redirect:/students";
        }
        model.addAttribute("student", studentData);
        return "student_detail";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteStudent(@PathVariable(value = "id") String id, RedirectAttributes redirectAtts) {
        boolean deleted = studentService.delete(id);
        if (!deleted) {
            redirectAtts.addFlashAttribute("error", String.format("Student Id: %s cannot be deleted", id));
        } else {
            redirectAtts.addFlashAttribute("success", String.format("Student Id: %s is deleted", id));
        }
        return "redirect:/students";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String displayFormAddStudent(Model model) {
        model.addAttribute("student", new StudentData());
        return "student_new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addStudent(@ModelAttribute(value = "student") StudentData student, RedirectAttributes redirectAtts) {
        StudentData studentData = studentService.add(student);
        if (studentData == null) {
            redirectAtts.addFlashAttribute("error", "Cannot add new student");
        } else {
            redirectAtts.addFlashAttribute("success", String.format("Student Id: %s is added", studentData.getId()));
        }
        return "redirect:/students";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String displayFormUpdateStudent(@PathVariable(value = "id") String id, Model model,
            RedirectAttributes redirectAtts) {
        StudentData studentData = studentService.get(id);
        if (studentData == null) {
            redirectAtts.addFlashAttribute("error", String.format("Student Id: %s not found", id));
            return "redirect:/students";
        }
        model.addAttribute("student", studentData);
        return "student_update";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute(value = "student") StudentData student, RedirectAttributes redirectAtts) {
        boolean updated = studentService.update(student);
        if (!updated) {
            redirectAtts.addFlashAttribute("error", "Cannot update current student");
        } else {
            redirectAtts.addFlashAttribute("success", String.format("Student Id: %s is updated", student.getId()));
        }
        return "redirect:/students";
    }

}
