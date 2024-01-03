package com.example.service;

import com.example.entity.Experiment;
import com.example.mapper.ExperimentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExperimentService {
    @Resource
    private ExperimentMapper experimentMapper;
    public PageInfo<Experiment> getExperiment(Integer page, Integer size,Experiment experiment){
        PageHelper.startPage(page,size);
        List<Experiment> experiments = experimentMapper.selectAll(experiment);
        return PageInfo.of(experiments);
    }

    public void addExperiment(Experiment experiment) {
        experimentMapper.insert(experiment);
    }

    public void updateExperiment(Experiment experiment) {
        experimentMapper.updateByPrimaryKey(experiment);
    }

    public void deleteExperiment(String itemno) {
        experimentMapper.deleteByPrimaryKey(itemno);
    }
}
