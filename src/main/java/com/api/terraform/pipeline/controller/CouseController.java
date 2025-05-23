package com.api.terraform.pipeline.controller;

import com.api.terraform.pipeline.dto.request.CourseRequest;
import com.api.terraform.pipeline.dto.response.CourseResponse;
import com.api.terraform.pipeline.service.CouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CouseController {


    private final CouseService courseService;

    public CouseController(CouseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CourseResponse> addCourse(@RequestBody CourseRequest course) {
        Optional<CourseResponse> courseResponse = courseService.addCourse(course);
        return new ResponseEntity<>(courseResponse.orElse(null), HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        List<CourseResponse> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<List<CourseResponse>> getCourseById(@PathVariable Integer id) {
        List<CourseResponse> course = courseService.getCourseById(id);
        return course.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CourseResponse> updateCourse(@PathVariable Integer id, @RequestBody CourseRequest newCourse) {
        boolean updated = courseService.updateCourse(id, newCourse);
        return updated ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CourseResponse> deleteCourse(@PathVariable Integer id) {
        boolean deleted = courseService.deleteCourse(id);

        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
