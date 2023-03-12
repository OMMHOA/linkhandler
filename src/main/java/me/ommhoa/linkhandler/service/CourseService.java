package me.ommhoa.linkhandler.service;

import com.google.common.collect.ImmutableList;
import me.ommhoa.linkhandler.model.Course;
import me.ommhoa.linkhandler.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CourseService {
    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses() {
        return ImmutableList.copyOf(courseRepository.findAll());
    }

    public void saveCourse(Course course) {
        logger.info("Saving course " + course);
        courseRepository.save(course);
    }

    public void deleteCourseByUuid(String courseUuid) {
        logger.info("Deleting course by UUID " + courseUuid);
        Course course = courseRepository.findByUuid(UUID.fromString(courseUuid));
        courseRepository.delete(course);
    }
}
