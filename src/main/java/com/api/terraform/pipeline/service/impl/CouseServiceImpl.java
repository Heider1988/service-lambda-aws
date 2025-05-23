package com.api.terraform.pipeline.service.impl;

import com.api.terraform.pipeline.dto.request.CourseRequest;
import com.api.terraform.pipeline.dto.response.CourseResponse;
import com.api.terraform.pipeline.service.CouseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CouseServiceImpl implements CouseService {

    private final List<CourseResponse> courses = new ArrayList<>();

    @Override
    public Optional<CourseResponse> addCourse(CourseRequest course) {
        courses.add(new CourseResponse(course.getId(), course.getName(), course.getPrice()));
        return Optional.of(new CourseResponse(course.getId(), course.getName(), course.getPrice()));
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return courses;
    }

    @Override
    public List<CourseResponse> getCourseById(Integer id) {
        return courses.stream().filter(courseResponse -> Objects.equals(courseResponse.id(), id)).toList();
    }

    @Override
    public boolean updateCourse(Integer id, CourseRequest newCourse) {

        List<CourseResponse> courseUpdate = getCourseById(id);
        if (courseUpdate.isEmpty()) {
            return false;
        }

        CourseResponse courseRemove = courseUpdate.get(0);
        courses.remove(courseRemove);
        courses.add(new CourseResponse(newCourse.getId(), newCourse.getName(), newCourse.getPrice()));
        return true;


    }

    @Override
    public boolean deleteCourse(Integer id) {
        return courses
                .removeIf(course -> Objects.equals(course.id(), id));
    }
}
