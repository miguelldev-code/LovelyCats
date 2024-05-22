package co.edu.usco.pw.springboot_crud01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(method = RequestMethod.GET)
    public String showStudentPage() {
        return "student";
    }
}
