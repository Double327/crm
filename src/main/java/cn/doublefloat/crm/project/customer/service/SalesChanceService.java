package cn.doublefloat.crm.project.customer.service;


import cn.doublefloat.crm.project.customer.domain.SalesChance;

public interface SalesChanceService {
    // 编辑营销机会
    int editChance(SalesChance salesChance);
    // 得到初始值
    SalesChance getBeginDate(Integer id);
    // 指派工作人员
    int assign(SalesChance salesChance);
    // 删除营销机会
    int deleteChance(Integer id);
    // 增加营销机会
    int insertChance(SalesChance salesChance);
}
