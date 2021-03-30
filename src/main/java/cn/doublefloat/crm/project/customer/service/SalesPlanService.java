package cn.doublefloat.crm.project.customer.service;

import cn.doublefloat.crm.project.customer.domain.SalesPlan;

import java.util.List;

/**
 * @author 仇武元
 */
public interface SalesPlanService {
    /**
     * 执行开发
     * @param salesPlan
     * @return
     */
    int startPlan(SalesPlan salesPlan);

    /**
     *  开发状态
     * @param salesPlan
     * @return
     */
    int changeStatus(SalesPlan salesPlan);

    /**
     * 从另一个表插入数据
     */
    void insertDate();

    /**
     * 查询所有
     * @return
     */
    List<SalesPlan> findAll();
}
