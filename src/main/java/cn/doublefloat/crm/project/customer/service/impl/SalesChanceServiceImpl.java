package cn.doublefloat.crm.project.customer.service.impl;

import cn.doublefloat.crm.project.customer.mapper.SalesChanceMapper;
import cn.doublefloat.crm.project.customer.domain.SalesChance;
import cn.doublefloat.crm.project.customer.service.SalesChanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SalesChanceServiceImpl implements SalesChanceService {
    @Resource
    private SalesChanceMapper salesChanceMapper;
    // 编辑营销机会
    @Override
    public int editChance(SalesChance salesChance) {
        int num = salesChanceMapper.editChance(salesChance);
        return num;

    }
    // 得到初始数据
    @Override
    public SalesChance getBeginDate(Integer id) {
        return salesChanceMapper.getBeginData(id);
    }
    // 指派工作人员
    @Override
    public int assign(SalesChance salesChance) {
        int num = salesChanceMapper.assign(salesChance);
        return num;
    }

    @Override
    public int deleteChance(Integer id) {
        int num = salesChanceMapper.deleteChance(id);
        return num;
    }
    //  增加营销机会
    @Override
    public int insertChance(SalesChance salesChance) {
       int num = salesChanceMapper.insertChance(salesChance);
       return num;
    }
}
