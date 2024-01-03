package com.example.mapper;

import com.example.entity.Experiment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ExperimentMapper {
    @Select("select * from experimentitems where itemname like concat('%',#{itemname},'%') and itemno like concat('%',#{itemno},'%') and courseno like concat('%',#{courseno},'%')")
    public List<Experiment> selectAll(Experiment experiment);
    @Insert("insert into experimentitems (itemno,itemname,itemtype,iscompulsory,itemhour,courseno) values (#{itemno},#{itemname},#{itemtype},#{iscompulsory},#{itemhour},#{courseno})")
    void insert(Experiment experiment);
    @Update("update experimentitems set itemno=#{itemno},itemname=#{itemname},itemtype=#{itemtype},iscompulsory=#{iscompulsory},itemhour=#{itemhour},courseno=#{courseno} where itemno=#{itemno}")
    void updateByPrimaryKey(Experiment experiment);
    @Delete("delete from experimentitems where itemno=#{itemno}")
    void deleteByPrimaryKey(String itemno);
}
