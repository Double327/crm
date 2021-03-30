package cn.doublefloat.crm.project.customer.service.impl;

import cn.doublefloat.crm.project.customer.mapper.SalesPlanMapper;
import cn.doublefloat.crm.project.customer.domain.SalesPlan;
import cn.doublefloat.crm.project.customer.service.SalesPlanService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author 仇武元
 */
@Service
public class SalesPlanImpl implements SalesPlanService {
    @Resource
    private SalesPlanMapper salesPlanMapper;

    /**
     * 执行开发
     * @param salesPlan
     * @return
     */
    @Override
    public int startPlan(SalesPlan salesPlan) {
        int num = salesPlanMapper.startPlan(salesPlan);
        return num;
    }

    /**
     * 开发状态
     * @param salesPlan
     * @return
     */
    @Override
    public int changeStatus(SalesPlan salesPlan) {
        int num = salesPlanMapper.changeStatus(salesPlan);
        return  num;
    }

    /**
     * 从另外一个表插入数据
     */
    @Override
    public void insertDate() {
        salesPlanMapper.insertDate();

    }

    /**
     * 查询所有数据 并且返回到列表中
     * @return
     */
    @Override
    public List<SalesPlan> findAll() {
        List<SalesPlan> salesPlanList = salesPlanMapper.findAll();
        return salesPlanList;
    }
}
