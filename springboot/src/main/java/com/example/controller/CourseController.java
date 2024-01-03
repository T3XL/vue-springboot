package com.example.controller;

import com.example.common.Result;
import com.example.entity.Course;
import com.example.service.CourseService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Resource
    private CourseService courseService;

    @GetMapping("/courselist")
    public Result getCourse(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "5") Integer size,
                            Course courses) {
        PageInfo<Course> course = courseService.getCourse(page, size, courses);
        return Result.success(course);
    }
    @PostMapping("/addcourse")
    public Result addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return Result.success();
    }
    @PutMapping("/updatecourse")
    public Result updateCourse(@RequestBody Course course){
        courseService.updateCourse(course);
        return Result.success();
    }
    @DeleteMapping("/deletecourse/{courseno}")
    public Result deleteCourse(@PathVariable String courseno){
        courseService.deleteCourse(courseno);
        return Result.success();
    }

}
