package com.api.terraform.pipeline.service;

import com.api.terraform.pipeline.dto.request.CourseRequest;
import com.api.terraform.pipeline.dto.response.CourseResponse;

import java.util.List;
import java.util.Optional;
// APENAS PARA EXEMPLOS - DESCONSIDERAR AS BOAS PRATICAS DE SOLID
public interface CouseService {

    Optional<CourseResponse> addCourse(CourseRequest course);

    List<CourseResponse>  getAllCourses();

    List<CourseResponse> getCourseById(Integer id);

    boolean updateCourse(Integer id, CourseRequest newCourse);

    boolean deleteCourse(Integer id);
}
