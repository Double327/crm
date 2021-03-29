package cn.doublefloat.crm.project.customer.service;

import cn.doublefloat.crm.project.customer.domain.Customer;

/**
 * @author 蒲万徐
 */
public interface CustomerService {
    /**
     * 1.查询客户
     * @return int
     */
    int findCustomer();

    /**
     * 2.添加客户
     * @param customer
     * @return int
     */
    int addCustomer(Customer customer);

    /**
     * 3.修改客户
     * @param customer
     * @return int
     */
    int updateCustomer(Customer customer);

    /**
     * 4.修改客户
     * @param id
     * @return int
     */
    int deleteCustomer(int id);
    /**
     * 5.设置状态
     */
    int setCusState(int id,int state);

}
