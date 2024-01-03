package com.example.controller;

import com.example.common.Result;
import com.example.entity.Experiment;
import com.example.service.ExperimentService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/experiment")
public class ExperimentController {
    @Resource
    private ExperimentService experimentService;
    @GetMapping("/experimentlist")
    public Result getExperiment(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "5") Integer size,
                                Experiment experiment) {
        PageInfo<Experiment> experiment1 = experimentService.getExperiment(page, size, experiment);
        return Result.success(experiment1);
    }
    @PostMapping("/addexperiment")
    public Result addExperiment(@RequestBody Experiment experiment) {
        experimentService.addExperiment(experiment);
        return Result.success();
    }
    @PutMapping("/updateexperiment")
    public Result updateExperiment(@RequestBody Experiment experiment) {
        experimentService.updateExperiment(experiment);
        return Result.success();
    }
    @DeleteMapping("/deleteexperiment/{itemno}")
    public Result deleteExperiment(@PathVariable String itemno) {
        experimentService.deleteExperiment(itemno);
        return Result.success();
    }
}
