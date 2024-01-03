package com.example.mapper;

import com.example.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseMapper {
    @Select("select * from courses where coursename like concat('%',#{coursename},'%') and courseno like concat('%',#{courseno},'%')")
    List<Course> selectAll(Course course);
    @Insert("insert into courses (courseno,coursename,credit,credithour,coursetype,experimenttype) values (#{courseno},#{coursename},#{credit},#{credithour},#{coursetype},#{experimenttype})")
    void insert(Course course);
    @Update("update courses set courseno=#{courseno},coursename=#{coursename},credit=#{credit},credithour=#{credithour},coursetype=#{coursetype},experimenttype=#{experimenttype} where courseno=#{courseno}")
    void updateByPrimaryKey(Course course);
    @Delete("delete from courses where courseno=#{courseno}")
    void deleteByPrimaryKey(String courseno);
}
