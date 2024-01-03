package com.example.service;

import com.example.entity.Course;
import com.example.mapper.CourseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseService {
    @Resource
    private CourseMapper courseMapper;

    public PageInfo<Course> getCourse(Integer page, Integer size,Course course) {
        PageHelper.startPage(page, size);
        List<Course> courses = courseMapper.selectAll(course);
        return PageInfo.of(courses);
    }


    public void addCourse(Course course) {
        courseMapper.insert(course);
    }

    public void updateCourse(Course course) {
        courseMapper.updateByPrimaryKey(course);
    }

    public void deleteCourse(String courseno) {
        courseMapper.deleteByPrimaryKey(courseno);
    }
}
