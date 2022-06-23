package edu.zju.se.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.zju.se.common.Result;
import edu.zju.se.entity.User;
import edu.zju.se.service.IMonitorService;
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
    private long value1;
    private long value2;
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

@Data
@Builder
class Returned_i{
    private long value;
    private String name;
}

@RestController
@RequestMapping("/monitor")
public class MonitorController {
    @Autowired
    IMonitorService monitorService;
    @Autowired
    IUserService userService;
    //全校核酸已完成、未完成
    @GetMapping("/w_number")
    public Result getNucleic_All(){
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        queryWrapper1.eq("nucleic", "已检测");
        queryWrapper2.eq("nucleic", "未检测");
        List<Returned_w> myList = new ArrayList<Returned_w>(){
            {
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper1))
                        .name("已完成核酸检测")
                        .build());
                add(Returned_w.builder()
                        .value2(userService.count(queryWrapper2))
                        .name("未完成核酸检测")
                        .build());
            }
        };
        return Result.success(myList);
    }

    //全校人员核酸校区统计
    @GetMapping("/w_campus")
    public Result getNucleic_Campus(){
        QueryWrapper<User> queryWrapper1_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper2_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper3_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper4_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper5_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper6_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper7_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper8_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper9_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper10_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper11_1 = new QueryWrapper<>();
        queryWrapper1_1.eq("campus", "紫金港校区").eq("nucleic", "已检测");
        queryWrapper2_1.eq("campus", "玉泉校区").eq("nucleic", "已检测");
        queryWrapper3_1.eq("campus", "西溪校区").eq("nucleic", "已检测");
        queryWrapper4_1.eq("campus", "华家池校区").eq("nucleic", "已检测");
        queryWrapper5_1.eq("campus", "之江校区").eq("nucleic", "已检测");
        queryWrapper6_1.eq("campus", "海宁校区").eq("nucleic", "已检测");
        queryWrapper7_1.eq("campus", "舟山校区").eq("nucleic", "已检测");
        queryWrapper8_1.eq("campus", "宁波校区").eq("nucleic", "已检测");
        queryWrapper9_1.eq("campus", "工程师学院").eq("nucleic", "已检测");
        queryWrapper10_1.eq("campus", "杭州国际科创中心").eq("nucleic", "已检测");
        queryWrapper11_1.eq("campus", "其他").eq("nucleic", "已检测");
        QueryWrapper<User> queryWrapper1_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper2_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper3_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper4_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper5_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper6_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper7_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper8_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper9_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper10_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper11_2 = new QueryWrapper<>();
        queryWrapper1_2.eq("campus", "紫金港校区").eq("nucleic", "未检测");
        queryWrapper2_2.eq("campus", "玉泉校区").eq("nucleic", "未检测");
        queryWrapper3_2.eq("campus", "西溪校区").eq("nucleic", "未检测");
        queryWrapper4_2.eq("campus", "华家池校区").eq("nucleic", "未检测");
        queryWrapper5_2.eq("campus", "之江校区").eq("nucleic", "未检测");
        queryWrapper6_2.eq("campus", "海宁校区").eq("nucleic", "未检测");
        queryWrapper7_2.eq("campus", "舟山校区").eq("nucleic", "未检测");
        queryWrapper8_2.eq("campus", "宁波校区").eq("nucleic", "未检测");
        queryWrapper9_2.eq("campus", "工程师学院").eq("nucleic", "未检测");
        queryWrapper10_2.eq("campus", "杭州国际科创中心").eq("nucleic", "未检测");
        queryWrapper11_2.eq("campus", "其他").eq("nucleic", "未检测");
        List<Returned_w> myList = new ArrayList<Returned_w>(){
            {
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper1_1))
                        .value2(userService.count(queryWrapper1_2))
                        .name("紫金港校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper2_1))
                        .value2(userService.count(queryWrapper2_2))
                        .name("玉泉校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper3_1))
                        .value2(userService.count(queryWrapper3_2))
                        .name("西溪校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper4_1))
                        .value2(userService.count(queryWrapper4_2))
                        .name("华家池校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper5_1))
                        .value2(userService.count(queryWrapper5_2))
                        .name("之江校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper6_1))
                        .value2(userService.count(queryWrapper6_2))
                        .name("海宁校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper7_1))
                        .value2(userService.count(queryWrapper7_2))
                        .name("舟山校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper8_1))
                        .value2(userService.count(queryWrapper8_2))
                        .name("宁波校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper9_1))
                        .value2(userService.count(queryWrapper9_2))
                        .name("工程师学院")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper10_1))
                        .value2(userService.count(queryWrapper10_2))
                        .name("杭州国际科创中心")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper11_1))
                        .value2(userService.count(queryWrapper11_2))
                        .name("其他")
                        .build());
            }
        };
        return Result.success(myList);
    }

    //全校未做核酸人员名单
    @GetMapping("/w_no_check")
    public Result getNotNucleic_All(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nucleic", "未检测");
        return Result.success(userService.list(queryWrapper));
    }

    //本科生核酸统计
    @GetMapping("/under_number")
    public Result getNucleic_Student(@RequestParam String date){
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
        QueryWrapper<User> queryWrapper0_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper1_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper2_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper3_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper4_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper5_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper6_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper0_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper1_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper2_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper3_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper4_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper5_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper6_2 = new QueryWrapper<>();
        queryWrapper0_1.eq("date", reStr0).eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper1_1.eq("date", reStr1).eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper2_1.eq("date", reStr2).eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper3_1.eq("date", reStr3).eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper4_1.eq("date", reStr4).eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper5_1.eq("date", reStr5).eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper6_1.eq("date", reStr6).eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper0_2.eq("date", reStr0).eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper1_2.eq("date", reStr1).eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper2_2.eq("date", reStr2).eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper3_2.eq("date", reStr3).eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper4_2.eq("date", reStr4).eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper5_2.eq("date", reStr5).eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper6_2.eq("date", reStr6).eq("nucleic", "未检测").eq("identity", "undergraduate");
        List<Returned_u> myList = new ArrayList<Returned_u>(){
            {
                add(Returned_u.builder()
                        .date(reStr0)
                        .value1(userService.count(queryWrapper0_1))
                        .value2(userService.count(queryWrapper0_2))
                        .name1("已完成核酸检测")
                        .name2("未完成核酸检测")
                        .build());
                add(Returned_u.builder()
                        .date(reStr1)
                        .value1(userService.count(queryWrapper1_1))
                        .value2(userService.count(queryWrapper1_2))
                        .name1("已完成核酸检测")
                        .name2("未完成核酸检测")
                        .build());
                add(Returned_u.builder()
                        .date(reStr2)
                        .value1(userService.count(queryWrapper2_1))
                        .value2(userService.count(queryWrapper2_2))
                        .name1("已完成核酸检测")
                        .name2("未完成核酸检测")
                        .build());
                add(Returned_u.builder()
                        .date(reStr3)
                        .value1(userService.count(queryWrapper3_1))
                        .value2(userService.count(queryWrapper3_2))
                        .name1("已完成核酸检测")
                        .name2("未完成核酸检测")
                        .build());
                add(Returned_u.builder()
                        .date(reStr4)
                        .value1(userService.count(queryWrapper4_1))
                        .value2(userService.count(queryWrapper4_2))
                        .name1("已完成核酸检测")
                        .name2("未完成核酸检测")
                        .build());
                add(Returned_u.builder()
                        .date(reStr5)
                        .value1(userService.count(queryWrapper5_1))
                        .value2(userService.count(queryWrapper5_2))
                        .name1("已完成核酸检测")
                        .name2("未完成核酸检测")
                        .build());
                add(Returned_u.builder()
                        .date(reStr6)
                        .value1(userService.count(queryWrapper6_1))
                        .value2(userService.count(queryWrapper6_2))
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
        QueryWrapper<User> queryWrapper1_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper2_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper3_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper4_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper5_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper6_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper7_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper8_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper9_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper10_1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper11_1 = new QueryWrapper<>();
        queryWrapper1_1.eq("campus", "紫金港校区").eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper2_1.eq("campus", "玉泉校区").eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper3_1.eq("campus", "西溪校区").eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper4_1.eq("campus", "华家池校区").eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper5_1.eq("campus", "之江校区").eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper6_1.eq("campus", "海宁校区").eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper7_1.eq("campus", "舟山校区").eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper8_1.eq("campus", "宁波校区").eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper9_1.eq("campus", "工程师学院").eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper10_1.eq("campus", "杭州国际科创中心").eq("nucleic", "已检测").eq("identity", "undergraduate");
        queryWrapper11_1.eq("campus", "其他").eq("nucleic", "已检测").eq("identity", "undergraduate");
        QueryWrapper<User> queryWrapper1_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper2_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper3_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper4_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper5_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper6_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper7_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper8_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper9_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper10_2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper11_2 = new QueryWrapper<>();
        queryWrapper1_2.eq("campus", "紫金港校区").eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper2_2.eq("campus", "玉泉校区").eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper3_2.eq("campus", "西溪校区").eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper4_2.eq("campus", "华家池校区").eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper5_2.eq("campus", "之江校区").eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper6_2.eq("campus", "海宁校区").eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper7_2.eq("campus", "舟山校区").eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper8_2.eq("campus", "宁波校区").eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper9_2.eq("campus", "工程师学院").eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper10_2.eq("campus", "杭州国际科创中心").eq("nucleic", "未检测").eq("identity", "undergraduate");
        queryWrapper11_2.eq("campus", "其他").eq("nucleic", "未检测").eq("identity", "undergraduate");
        List<Returned_w> myList = new ArrayList<Returned_w>(){
            {
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper1_1))
                        .value2(userService.count(queryWrapper1_2))
                        .name("紫金港校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper2_1))
                        .value2(userService.count(queryWrapper2_2))
                        .name("玉泉校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper3_1))
                        .value2(userService.count(queryWrapper3_2))
                        .name("西溪校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper4_1))
                        .value2(userService.count(queryWrapper4_2))
                        .name("华家池校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper5_1))
                        .value2(userService.count(queryWrapper5_2))
                        .name("之江校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper6_1))
                        .value2(userService.count(queryWrapper6_2))
                        .name("海宁校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper7_1))
                        .value2(userService.count(queryWrapper7_2))
                        .name("舟山校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper8_1))
                        .value2(userService.count(queryWrapper8_2))
                        .name("宁波校区")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper9_1))
                        .value2(userService.count(queryWrapper9_2))
                        .name("工程师学院")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper10_1))
                        .value2(userService.count(queryWrapper10_2))
                        .name("杭州国际科创中心")
                        .build());
                add(Returned_w.builder()
                        .value1(userService.count(queryWrapper11_1))
                        .value2(userService.count(queryWrapper11_2))
                        .name("其他")
                        .build());
            }
        };
        return Result.success(myList);
    }

    //本科生未检测名单
    @GetMapping("/under_no_check")
    public Result getNotNucleic_Student(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nucleic", "未检测").eq("identity", "undergraduate");
        return Result.success(userService.list(queryWrapper));
    }

    //在校人数分校区统计
    @GetMapping("/in_school")
    public Result getCount_All(){
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper3 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper4 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper5 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper6 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper7 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper8 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper9 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper10 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper11 = new QueryWrapper<>();
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
        List<Returned_i> myList = new ArrayList<Returned_i>(){
            {
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper1))
                        .name("紫金港校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper2))
                        .name("玉泉校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper3))
                        .name("西溪校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper4))
                        .name("华家池校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper5))
                        .name("之江校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper6))
                        .name("海宁校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper7))
                        .name("舟山校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper8))
                        .name("宁波校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper9))
                        .name("工程师学院")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper10))
                        .name("杭州国际科创中心")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper11))
                        .name("其他")
                        .build());
            }
        };
        return Result.success(myList);
    }

    @GetMapping("/unattendlist")
    public Result unattendList(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("attend", false);
        return Result.success(userService.list(queryWrapper));
    }

    @GetMapping("/campusnum")
    public Result campusnum(){
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper3 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper4 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper5 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper6 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper7 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper8 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper9 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper10 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper11 = new QueryWrapper<>();
        queryWrapper1.eq("campus", "紫金港校区").eq("attend", true);
        queryWrapper2.eq("campus", "玉泉校区").eq("attend", true);
        queryWrapper3.eq("campus", "西溪校区").eq("attend", true);
        queryWrapper4.eq("campus", "华家池校区").eq("attend", true);
        queryWrapper5.eq("campus", "之江校区").eq("attend", true);
        queryWrapper6.eq("campus", "海宁校区").eq("attend", true);
        queryWrapper7.eq("campus", "舟山校区").eq("attend", true);
        queryWrapper8.eq("campus", "宁波校区").eq("attend", true);
        queryWrapper9.eq("campus", "工程师学院").eq("attend", true);
        queryWrapper10.eq("campus", "杭州国际科创中心").eq("attend", true);
        queryWrapper11.eq("campus", "其他").eq("attend", true);
        List<Returned_i> myList = new ArrayList<Returned_i>(){
            {
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper1))
                        .name("紫金港校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper2))
                        .name("玉泉校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper3))
                        .name("西溪校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper4))
                        .name("华家池校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper5))
                        .name("之江校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper6))
                        .name("海宁校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper7))
                        .name("舟山校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper8))
                        .name("宁波校区")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper9))
                        .name("工程师学院")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper10))
                        .name("杭州国际科创中心")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper11))
                        .name("其他")
                        .build());
            }
        };
        return Result.success(myList);
    }

    @GetMapping("/attendnum")
    public Result attendnum(){
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        queryWrapper1.eq("attend", true);
        queryWrapper2.eq("attend", false);
        List<Returned_i> myList = new ArrayList<Returned_i>(){
            {
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper1))
                        .name("已打卡")
                        .build());
                add(Returned_i.builder()
                        .value(userService.count(queryWrapper2))
                        .name("未打卡")
                        .build());
            }
        };
        return Result.success(myList);
    }

}
