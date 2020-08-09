package me.ommhoa.linkhandler.repository;

import me.ommhoa.linkhandler.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {
}
