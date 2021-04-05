package me.ommhoa.linkhandler.web;

import com.google.common.collect.ImmutableList;
import me.ommhoa.linkhandler.model.Course;
import me.ommhoa.linkhandler.model.LanguageLevel;
import me.ommhoa.linkhandler.model.Teacher;
import me.ommhoa.linkhandler.repository.CourseRepository;
import me.ommhoa.linkhandler.repository.LanguageRepository;
import me.ommhoa.linkhandler.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class CourseController {
    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/courses")
    public String getLanguages(Model model) {
        List<Course> courses = ImmutableList.copyOf(courseRepository.findAll());
        model.addAttribute("courses", courses);
        Course course = new Course();
        course.setTeacher(new Teacher());
        model.addAttribute("newCourse", course);
        model.addAttribute("languages", languageRepository.findAll());
        model.addAttribute("teachers", teacherRepository.findAll());
        model.addAttribute("levels", LanguageLevel.values());
        return "courses";
    }

    @PostMapping("/courses")
    public String addLanguage(@ModelAttribute Course course) {
        course.setUuid(UUID.randomUUID());
        logger.info(course.toString());
        courseRepository.save(course);
        return "redirect:courses";
    }

    @GetMapping("/courses/{courseUuid}/delete")
    public String deleteLanguage(@PathVariable String courseUuid) {
        Course course = courseRepository.findByUuid(UUID.fromString(courseUuid));
        courseRepository.delete(course);
        return "redirect:/courses";
    }
}
