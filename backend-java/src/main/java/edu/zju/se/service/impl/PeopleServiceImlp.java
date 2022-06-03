package edu.zju.se.service.impl;

import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zju.se.entity.Nucleic;
import edu.zju.se.entity.People;
import edu.zju.se.mapper.PeopleMapper;
import edu.zju.se.service.IPeopleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImlp extends ServiceImpl<PeopleMapper, People> implements IPeopleService{
    @Override
    public void setNucleicTrue(List<Nucleic> resultList){
        LambdaUpdateChainWrapper<People> updateWrapper = new LambdaUpdateChainWrapper<>(getBaseMapper());
        for (Nucleic res : resultList) {
            updateWrapper.eq(People::getId, res.getStaffId())
                    .set(People::getNucleic, "已检测")
                    .set(People::getDate, res.getAppDate())
                    .update();
        }
    }
}
