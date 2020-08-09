package me.ommhoa.linkhandler.web;

import com.google.common.collect.ImmutableList;
import me.ommhoa.linkhandler.model.Teacher;
import me.ommhoa.linkhandler.repository.CourseRepository;
import me.ommhoa.linkhandler.repository.LanguageRepository;
import me.ommhoa.linkhandler.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/courses")
    public String getLanguages(Model model) {
        List<Teacher> teachers = ImmutableList.copyOf(teacherRepository.findAll());
        model.addAttribute("teachers", teachers);
        model.addAttribute("newTeacher", new Teacher());
        model.addAttribute("languages", languageRepository.findAll());
        return "courses";
    }

    @PostMapping("/courses")
    public String addLanguage(@ModelAttribute Teacher teacher) {
        teacherRepository.save(teacher);
        return "redirect:teachers";
    }

    @GetMapping("/courses/{course}/delete")
    public String deleteLanguage(@PathVariable String teacher) {
        teacherRepository.delete(new Teacher(teacher));
        return "redirect:/teachers";
    }
}
