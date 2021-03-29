package cn.doublefloat.crm.project.customer.service;

import cn.doublefloat.crm.project.customer.domain.Drains;

import java.util.List;

/**
 * @author 卢颢文
 */
public interface DrainsService {

    /**
     * 查询所有流失顾客信息
     */
    List<Drains> selectCustomer();

    /**
     * 设置状态为暂缓流失
     */
    int waitDrains(Drains drains);

    /**
     * 设置状态为确认流失
     */
    int okDrains(Drains drains);

    /**
     * 增加流失顾客
     */
    int insertCustomer(Drains drains);

    /**
     * 按照id查询顾客
     *
     * @param id
     * @return
     */
    Drains selectCustomerbyId(int id);
}
