package me.ommhoa.linkhandler.view;

import me.ommhoa.linkhandler.model.Language;
import me.ommhoa.linkhandler.model.Teacher;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

@Component
public class TeacherView {
    static final String PAGE = "teachers";
    public static class Parameters {
        private Teacher newTeacher;
        private List<Teacher> teachers;
        private List<Language> languages;

        public Parameters setNewTeacher(Teacher newTeacher) {
            this.newTeacher = newTeacher;
            return this;
        }

        public Parameters setTeachers(List<Teacher> teachers) {
            this.teachers = teachers;
            return this;
        }

        public Parameters setLanguages(List<Language> languages) {
            this.languages = languages;
            return this;
        }
    }

    public String renderPage(Model model, Parameters params) {
        model.addAttribute("teachers", params.teachers);
        model.addAttribute("newTeacher", params.newTeacher);
        model.addAttribute("languages", params.languages);
        return PAGE;
    }
}
