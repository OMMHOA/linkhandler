package me.ommhoa.linkhandler.web;

import com.google.common.collect.ImmutableList;
import me.ommhoa.linkhandler.model.Teacher;
import me.ommhoa.linkhandler.repository.LanguageRepository;
import me.ommhoa.linkhandler.repository.TeacherRepository;
import me.ommhoa.linkhandler.service.LanguageService;
import me.ommhoa.linkhandler.service.TeacherService;
import me.ommhoa.linkhandler.view.TeacherView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private TeacherView teacherView;

    @GetMapping("/teachers")
    public String getTeachers(Model model) {
        return teacherView.renderPage(
                model,
                new TeacherView.Parameters()
                        .setLanguages(languageService.getLanguages())
                        .setTeachers(teacherService.getTeachers())
                        .setNewTeacher(new Teacher())
        );
    }

    @PostMapping("/teachers")
    public String addTeacher(@ModelAttribute Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/{teacher}/delete")
    public String deleteTeacher(@PathVariable String teacherName) {
        teacherService.deleteTeacherByName(teacherName);
        return "redirect:/teachers";
    }
}
