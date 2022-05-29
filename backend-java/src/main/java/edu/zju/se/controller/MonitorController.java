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
import java.text.SimpleDateFormat;
import java.util.*;

@Data
@Builder
class Returned_w{
    private long value;
    private String name;
}

@Data
@Builder
class Returned_u{
    private String date;
    private long value1;
    private long value2;
    private String name1;
    private String name2;
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
//        QueryWrapper<People> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("date", date);
//        return Result.success(peopleService.list(queryWrapper));
//        return Result.success(studentService.count(...));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date dt = new Date();
        try {
            dt = sdf.parse(date);
        }catch (Exception exception) {
            exception.printStackTrace();
        }
        Calendar now = Calendar.getInstance();
        now.setTime(dt);
        Date dt0 = now.getTime();
        now.add(Calendar.DAY_OF_YEAR, 1);
        Date dt1 = now.getTime();
        now.add(Calendar.DAY_OF_YEAR, 1);
        Date dt2 = now.getTime();
        now.add(Calendar.DAY_OF_YEAR, 1);
        Date dt3 = now.getTime();
        now.add(Calendar.DAY_OF_YEAR, 1);
        Date dt4 = now.getTime();
        now.add(Calendar.DAY_OF_YEAR, 1);
        Date dt5 = now.getTime();
        now.add(Calendar.DAY_OF_YEAR, 1);
        Date dt6 = now.getTime();
        String reStr0 = sdf.format(dt0);
        String reStr1 = sdf.format(dt1);
        String reStr2 = sdf.format(dt2);
        String reStr3 = sdf.format(dt3);
        String reStr4 = sdf.format(dt4);
        String reStr5 = sdf.format(dt5);
        String reStr6 = sdf.format(dt6);
        QueryWrapper<People> queryWrapper0_1 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper1_1 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper2_1 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper3_1 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper4_1 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper5_1 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper6_1 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper0_2 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper1_2 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper2_2 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper3_2 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper4_2 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper5_2 = new QueryWrapper<>();
        QueryWrapper<People> queryWrapper6_2 = new QueryWrapper<>();
        queryWrapper0_1.eq("date", reStr0).eq("nucleic", "已检测");
        queryWrapper1_1.eq("date", reStr1).eq("nucleic", "已检测");
        queryWrapper2_1.eq("date", reStr2).eq("nucleic", "已检测");
        queryWrapper3_1.eq("date", reStr3).eq("nucleic", "已检测");
        queryWrapper4_1.eq("date", reStr4).eq("nucleic", "已检测");
        queryWrapper5_1.eq("date", reStr5).eq("nucleic", "已检测");
        queryWrapper6_1.eq("date", reStr6).eq("nucleic", "已检测");
        queryWrapper0_2.eq("date", reStr0).eq("nucleic", "未检测");
        queryWrapper1_2.eq("date", reStr1).eq("nucleic", "未检测");
        queryWrapper2_2.eq("date", reStr2).eq("nucleic", "未检测");
        queryWrapper3_2.eq("date", reStr3).eq("nucleic", "未检测");
        queryWrapper4_2.eq("date", reStr4).eq("nucleic", "未检测");
        queryWrapper5_2.eq("date", reStr5).eq("nucleic", "未检测");
        queryWrapper6_2.eq("date", reStr6).eq("nucleic", "未检测");
        List<Returned_u> myList = new ArrayList<Returned_u>(){
            {
                add(Returned_u.builder()
                        .date(reStr0)
                        .value1(peopleService.count(queryWrapper0_1))
                        .value2(peopleService.count(queryWrapper0_2))
                        .name1("已完成核酸检测")
                        .name2("未完成核酸检测")
                        .build());
                add(Returned_u.builder()
                        .date(reStr1)
                        .value1(peopleService.count(queryWrapper1_1))
                        .value2(peopleService.count(queryWrapper1_2))
                        .name1("已完成核酸检测")
                        .name2("未完成核酸检测")
                        .build());
                add(Returned_u.builder()
                        .date(reStr2)
                        .value1(peopleService.count(queryWrapper2_1))
                        .value2(peopleService.count(queryWrapper2_2))
                        .name1("已完成核酸检测")
                        .name2("未完成核酸检测")
                        .build());
                add(Returned_u.builder()
                        .date(reStr3)
                        .value1(peopleService.count(queryWrapper3_1))
                        .value2(peopleService.count(queryWrapper3_2))
                        .name1("已完成核酸检测")
                        .name2("未完成核酸检测")
                        .build());
                add(Returned_u.builder()
                        .date(reStr4)
                        .value1(peopleService.count(queryWrapper4_1))
                        .value2(peopleService.count(queryWrapper4_2))
                        .name1("已完成核酸检测")
                        .name2("未完成核酸检测")
                        .build());
                add(Returned_u.builder()
                        .date(reStr5)
                        .value1(peopleService.count(queryWrapper5_1))
                        .value2(peopleService.count(queryWrapper5_2))
                        .name1("已完成核酸检测")
                        .name2("未完成核酸检测")
                        .build());
                add(Returned_u.builder()
                        .date(reStr6)
                        .value1(peopleService.count(queryWrapper6_1))
                        .value2(peopleService.count(queryWrapper6_2))
                        .name1("已完成核酸检测")
                        .name2("未完成核酸检测")
                        .build());

            }
        };
        return Result.success(myList);
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
