package cn.doublefloat.crm.project.customer.service;

import cn.doublefloat.crm.project.customer.domain.SalesPlan;

public interface SalesPlanService {
    //执行开发
    int startPlan(SalesPlan salesPlan);
    // 开发状态
    int changeStatus(SalesPlan salesPlan);
}
