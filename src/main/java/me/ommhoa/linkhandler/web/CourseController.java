package me.ommhoa.linkhandler.web;

import me.ommhoa.linkhandler.model.Course;
import me.ommhoa.linkhandler.model.LanguageLevel;
import me.ommhoa.linkhandler.model.Teacher;
import me.ommhoa.linkhandler.service.CourseService;
import me.ommhoa.linkhandler.service.LanguageService;
import me.ommhoa.linkhandler.service.TeacherService;
import me.ommhoa.linkhandler.view.CourseView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class CourseController {
    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseView courseView;

    @GetMapping("/courses")
    public String getCourses(Model model) {
        Course course = new Course();
        course.setTeacher(new Teacher());
        return courseView.renderPage(
                model,
                new CourseView.Parameters()
                        .setNewCourse(course)
                        .setCourses(courseService.getCourses())
                        .setLanguages(languageService.getLanguages())
                        .setTeachers(teacherService.getTeachers())
                        .setLanguageLevels(LanguageLevel.values())
        );
    }

    @PostMapping("/courses")
    public String addCourse(@ModelAttribute Course course) {
        course.setUuid(UUID.randomUUID());
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/courses/{courseUuid}/delete")
    public String deleteCourse(@PathVariable String courseUuid) {
        courseService.deleteCourseByUuid(courseUuid);
        return "redirect:/courses";
    }
}
