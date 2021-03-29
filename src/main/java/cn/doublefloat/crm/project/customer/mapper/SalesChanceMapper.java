package cn.doublefloat.crm.project.customer.mapper;


import cn.doublefloat.crm.project.customer.domain.SalesChance;

public interface SalesChanceMapper {
    /**
     * 编辑营销机会
     *
     * @param salesChance 营销机会信息
     * @return 结果
     */
    int editChance(SalesChance salesChance);

    // 得到初始数据
    SalesChance getBeginData(Integer id);

    // 指派工作人员
    int assign(SalesChance salesChance);

    // 删除营销机会
    int deleteChance(Integer id);

    // 增加营销机会
    int insertChance(SalesChance salesChance);
}
