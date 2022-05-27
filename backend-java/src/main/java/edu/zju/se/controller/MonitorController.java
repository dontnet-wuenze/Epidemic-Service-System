package edu.zju.se.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.zju.se.common.Result;
import edu.zju.se.entity.User;
import edu.zju.se.service.IMonitorService;
import edu.zju.se.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/monitor")
public class MonitorController {
    @Autowired
    IMonitorService monitorService;
    //全校核酸已完成、未完成
    @GetMapping("/w_number")
    public Result getNucleic_All(){
        String s="[{ value: 1048, name: '已完成核酸检测'},{ value: 100, name: '未完成核酸检测'}]";
        return Result.success(s);
//        return Result.success(peopleService.count(...));
    }

    //全校人员核酸校区统计
    @GetMapping("/w_campus")
    public Result getNucleic_Campus(){
        String s="[\n" +
                "            { value: 120, name:'紫金港校区' },\n" +
                "            { value: 132, name:'玉泉校区' },\n" +
                "            { value: 101, name:'西溪校区' },\n" +
                "            { value: 134, name:'华家池校区' },\n" +
                "            { value: 90, name:'之江校区' },\n" +
                "            { value: 230, name:'海宁校区' },\n" +
                "            { value: 210, name:'舟山校区' },\n" +
                "            { value: 120, name:'宁波校区' },\n" +
                "            { value: 150, name:'工程师学院' },\n" +
                "            { value: 80, name:'杭州国际科创中心' },\n" +
                "            { value: 10, name:'其他' }\n" +
                "    ]";
        return Result.success(s);
//        return Result.success(peopleService.count(...));
    }

    //全校未做核酸人员名单
    @GetMapping("/w_no_check")
    public Result getNotNucleic_All(){
        String s="全校未做核酸人员名单";
        return Result.success(s);
//        return Result.success(peopleService.);
    }

    //本科生核酸统计
    @GetMapping("/under_number")
    public Result getNucleic_Student(){
        String s="[\n" +
                "          { date: 2019-02-25, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' },\n" +
                "          { date: 2019-02-26, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' }\n" +
                "          { date: 2019-02-27, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' }\n" +
                "          { date: 2019-02-28, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' }\n" +
                "          { date: 2019-03-01, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' }\n" +
                "          { date: 2019-03-02, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' }\n" +
                "          { date: 2019-03-03, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' }\n" +
                "    ]";
        return Result.success(s);
//        return Result.success(studentService.count(...));
    }

    //本科生核酸统计校区统计
    @GetMapping("/under_campus")
    public Result getNucleic_Student_Campus(){
        String s="[\n" +
                "            { value: 120, name:'紫金港校区' },\n" +
                "            { value: 132, name:'玉泉校区' },\n" +
                "            { value: 101, name:'西溪校区' },\n" +
                "            { value: 134, name:'华家池校区' },\n" +
                "            { value: 90, name:'之江校区' },\n" +
                "            { value: 230, name:'海宁校区' },\n" +
                "            { value: 210, name:'舟山校区' },\n" +
                "            { value: 120, name:'宁波校区' },\n" +
                "            { value: 150, name:'工程师学院' },\n" +
                "            { value: 80, name:'杭州国际科创中心' },\n" +
                "            { value: 10, name:'其他' }\n" +
                "    ]";
        return Result.success(s);
//        return Result.success(peopleService.count(...));
    }

    //本科生未检测名单
    @GetMapping("/under_no_check")
    public Result getNotNucleic_Student(){
        String s="Fuck nucleic!";
        return Result.success(s);
//        return Result.success(peopleService.count(...));
    }

    //在校人数分校区统计
    @GetMapping("/in_school")
    public Result getCount_All(){
        String s="[\n" +
                "            { value: 1048, name: '已完成核酸检测' },\n" +
                "            { value: 100, name: '未完成核酸检测' }，\n" +
                "            { value: 120, name:'紫金港校区' },\n" +
                "            { value: 132, name:'玉泉校区' },\n" +
                "            { value: 101, name:'西溪校区' },\n" +
                "            { value: 134, name:'华家池校区' },\n" +
                "            { value: 90, name:'之江校区' },\n" +
                "            { value: 230, name:'海宁校区' },\n" +
                "            { value: 210, name:'舟山校区' },\n" +
                "            { value: 120, name:'宁波校区' },\n" +
                "            { value: 150, name:'工程师学院' },\n" +
                "            { value: 80, name:'杭州国际科创中心' },\n" +
                "            { value: 10, name:'其他' }\n" +
                "    ]";
        return Result.success(s);
//        return Result.success(peopleService.);
    }
}