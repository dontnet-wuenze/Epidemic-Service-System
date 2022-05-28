package edu.zju.se.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.zju.se.common.Result;
import edu.zju.se.entity.People;
import edu.zju.se.entity.User;
import edu.zju.se.service.IMonitorService;
import edu.zju.se.service.IPeopleService;
import edu.zju.se.service.IUserService;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Data
@Builder
class Returned_w{
    private long value;
    private String name;
}

@RestController
@RequestMapping("/monitor")
public class MonitorController {
    @Autowired
    IMonitorService monitorService;
    @Autowired
    IPeopleService peopleService;
    //全校核酸已完成、未完成
    @GetMapping("/w_number")
    public Result getNucleic_All(){
        QueryWrapper<People> queryWrapper1 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper2 = new QueryWrapper<>();
        queryWrapper1.eq("nucleic", "已检测");
        queryWrapper2.eq("nucleic", "未检测");
        List<Returned_w> myList = new ArrayList<Returned_w>(){
            {
                add(Returned_w.builder()
                        .value(peopleService.count(queryWrapper1))
                        .name("已完成核酸检测")
                        .build());
                add(Returned_w.builder()
                        .value(peopleService.count(queryWrapper2))
                        .name("未完成核酸检测")
                        .build());
            }
        };
        return Result.success(myList);
    }

    //全校人员核酸校区统计
    @GetMapping("/w_campus")
    public Result getNucleic_Campus(){
        QueryWrapper<People> queryWrapper1 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper2 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper3 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper4 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper5 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper6 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper7 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper8 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper9 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper10 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper11 = new QueryWrapper<>();
        queryWrapper1.eq("campus", "紫金港校区");
        queryWrapper2.eq("campus", "玉泉校区");
        queryWrapper3.eq("campus", "西溪校区");
        queryWrapper4.eq("campus", "华家池校区");
        queryWrapper5.eq("campus", "之江校区");
        queryWrapper6.eq("campus", "海宁校区");
        queryWrapper7.eq("campus", "舟山校区");
        queryWrapper8.eq("campus", "宁波校区");
        queryWrapper9.eq("campus", "工程师学院");
        queryWrapper10.eq("campus", "杭州国际科创中心");
        queryWrapper11.eq("campus", "其他");
        List<Returned_w> myList = new ArrayList<Returned_w>(){
            {
                add(Returned_w.builder()
                        .value(peopleService.count(queryWrapper1))
                        .name("紫金港校区")
                        .build());
                add(Returned_w.builder()
                        .value(peopleService.count(queryWrapper2))
                        .name("玉泉校区")
                        .build());
                add(Returned_w.builder()
                        .value(peopleService.count(queryWrapper3))
                        .name("西溪校区")
                        .build());
                add(Returned_w.builder()
                        .value(peopleService.count(queryWrapper4))
                        .name("华家池校区")
                        .build());
                add(Returned_w.builder()
                        .value(peopleService.count(queryWrapper5))
                        .name("之江校区")
                        .build());
                add(Returned_w.builder()
                        .value(peopleService.count(queryWrapper6))
                        .name("海宁校区")
                        .build());
                add(Returned_w.builder()
                        .value(peopleService.count(queryWrapper7))
                        .name("舟山校区")
                        .build());
                add(Returned_w.builder()
                        .value(peopleService.count(queryWrapper8))
                        .name("宁波校区")
                        .build());
                add(Returned_w.builder()
                        .value(peopleService.count(queryWrapper9))
                        .name("工程师学院")
                        .build());
                add(Returned_w.builder()
                        .value(peopleService.count(queryWrapper10))
                        .name("杭州国际科创中心")
                        .build());
                add(Returned_w.builder()
                        .value(peopleService.count(queryWrapper11))
                        .name("其他")
                        .build());
            }
        };
        return Result.success(myList);
    }

    //全校未做核酸人员名单
    @GetMapping("/w_no_check")
    public Result getNotNucleic_All(){
//        String s="全校未做核酸人员名单";
//        return Result.success(s);
        QueryWrapper<People> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nucleic", "未检测");
        return Result.success(peopleService.list(queryWrapper));
//        return Result.success(peopleService.);
    }

    //本科生核酸统计
    @GetMapping("/under_number")
    public Result getNucleic_Student(@RequestParam String date){
//        String s="[\n" +
//                "          { date: 2019-02-25, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' },\n" +
//                "          { date: 2019-02-26, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' }\n" +
//                "          { date: 2019-02-27, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' }\n" +
//                "          { date: 2019-02-28, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' }\n" +
//                "          { date: 2019-03-01, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' }\n" +
//                "          { date: 2019-03-02, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' }\n" +
//                "          { date: 2019-03-03, value1:20, value2:20, name1: '已完成核酸检测', name2: '未完成核酸检测' }\n" +
//                "    ]";
        QueryWrapper<People> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date", date);
        return Result.success(peopleService.list(queryWrapper));
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
