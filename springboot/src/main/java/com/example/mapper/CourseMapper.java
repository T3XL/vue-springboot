package com.example.mapper;

import com.example.entity.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {
    @Select("select * from courses where coursename like concat('%',#{coursename},'%') and courseno like concat('%',#{courseno},'%')")
    List<Course> selectAll(Course course);
}
