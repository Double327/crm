package cn.doublefloat.crm.project.customer.mapper;

import cn.doublefloat.crm.project.customer.domain.SalesPlan;

import java.util.List;

/**
 * @author 仇武元
 */
public interface SalesPlanMapper {
    /**
     * 执行开发
     * @param salesPlan
     * @return
     */
    int startPlan(SalesPlan salesPlan);

    /**
     * 开发状态
     * @param salesPlan
     * @return
     */
    int changeStatus(SalesPlan salesPlan);

    /**
     * 从另外一个表插入语句
     */
    void insertDate();

    /**
     * 查询所有数据
     * @return
     */
    List<SalesPlan> findAll();
}
