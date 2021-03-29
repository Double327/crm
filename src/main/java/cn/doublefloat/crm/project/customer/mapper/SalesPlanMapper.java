package cn.doublefloat.crm.project.customer.mapper;

import cn.doublefloat.crm.project.customer.domain.SalesPlan;

public interface SalesPlanMapper {
    // 执行开发
    int startPlan(SalesPlan salesPlan);
    // 开发状态
    int changeStatus(SalesPlan salesPlan);
}
