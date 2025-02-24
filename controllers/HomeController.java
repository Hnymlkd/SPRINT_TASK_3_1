package kz.bitlab.techorda2025.secondProject.controllers;

import kz.bitlab.techorda2025.secondProject.db.DBManager;
import kz.bitlab.techorda2025.secondProject.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {
    @GetMapping ("/home")
    public String getHome(Model model) {
        model.addAttribute("students", DBManager.getStudentList());
        return "home";
    }


    @GetMapping("/addStudent")
    public String getAddStudent(Model model) {
        model.addAttribute("cities", DBManager.getCities());
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestParam(name="name") String name,
                             @RequestParam(name="surname") String surname,
                             @RequestParam(name="city") int city,
                             @RequestParam(name="exam") int exam){
        Student student = Student.builder()
                .name(name)
                .surname(surname)
                .city(DBManager.getCities().get(city))
                .exam(exam)
                .mark(DBManager.setMarkObject(exam))
                .build();

        DBManager.addStudent(student);
        return "redirect:/home";
    }
}
