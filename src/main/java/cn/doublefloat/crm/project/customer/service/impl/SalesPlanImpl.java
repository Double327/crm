package cn.doublefloat.crm.project.customer.service.impl;

import cn.doublefloat.crm.project.customer.mapper.SalesPlanMapper;
import cn.doublefloat.crm.project.customer.domain.SalesPlan;
import cn.doublefloat.crm.project.customer.service.SalesPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SalesPlanImpl implements SalesPlanService {
    @Resource
    private SalesPlanMapper salesPlanMapper;
    //执行开发
    @Override
    public int startPlan(SalesPlan salesPlan) {
        int num = salesPlanMapper.startPlan(salesPlan);
        return num;
    }
    // 开发状态
    @Override
    public int changeStatus(SalesPlan salesPlan) {
        int num = salesPlanMapper.changeStatus(salesPlan);
        return  num;
    }
}
