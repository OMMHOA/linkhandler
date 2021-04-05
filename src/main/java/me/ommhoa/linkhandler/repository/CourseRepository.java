package me.ommhoa.linkhandler.repository;

import me.ommhoa.linkhandler.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {
    Course findByUuid(UUID uuid);
}
