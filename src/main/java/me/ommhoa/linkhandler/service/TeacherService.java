package me.ommhoa.linkhandler.service;

import com.google.common.collect.ImmutableList;
import me.ommhoa.linkhandler.model.Teacher;
import me.ommhoa.linkhandler.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherService {
    private static final Logger logger = LoggerFactory.getLogger(TeacherService.class);

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        return ImmutableList.copyOf(teacherRepository.findAll());
    }

    public void saveTeacher(Teacher teacher) {
        logger.info("Saving teacher " + teacher);
        teacherRepository.save(teacher);
    }

    public void deleteTeacherByName(String teacherName) {
        logger.info("Deleting teacher " + teacherName);
        teacherRepository.delete(new Teacher(teacherName));
    }
}
