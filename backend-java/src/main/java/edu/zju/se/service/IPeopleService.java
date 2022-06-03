package edu.zju.se.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.zju.se.entity.Nucleic;
import edu.zju.se.entity.People;

import java.util.List;

public interface IPeopleService extends IService<People> {

    public void setNucleicTrue(List<Nucleic> resultList);
}
