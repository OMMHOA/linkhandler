package me.ommhoa.linkhandler.view;

import me.ommhoa.linkhandler.model.Course;
import me.ommhoa.linkhandler.model.Language;
import me.ommhoa.linkhandler.model.LanguageLevel;
import me.ommhoa.linkhandler.model.Teacher;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

@Component
public class CourseView {
    static final String PAGE = "courses";
    public static class Parameters {
        private Course newCourse;
        private List<Course> courses;
        private List<Language> languages;
        private List<Teacher> teachers;
        private LanguageLevel[] languageLevels;

        public Parameters setNewCourse(Course newCourse) {
            this.newCourse = newCourse;
            return this;
        }

        public Parameters setCourses(List<Course> courses) {
            this.courses = courses;
            return this;
        }

        public Parameters setLanguages(List<Language> languages) {
            this.languages = languages;
            return this;
        }

        public Parameters setTeachers(List<Teacher> teachers) {
            this.teachers = teachers;
            return this;
        }

        public Parameters setLanguageLevels(LanguageLevel[] languageLevels) {
            this.languageLevels = languageLevels;
            return this;
        }
    }

    public String renderPage(Model model, Parameters params) {
        model.addAttribute("newCourse", params.newCourse);
        model.addAttribute("courses", params.courses);
        model.addAttribute("languages", params.languages);
        model.addAttribute("teachers", params.teachers);
        model.addAttribute("levels", params.languageLevels);
        return PAGE;
    }
}
