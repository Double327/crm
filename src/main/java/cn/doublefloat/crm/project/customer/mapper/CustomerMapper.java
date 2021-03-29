package cn.doublefloat.crm.project.customer.mapper;

import cn.doublefloat.crm.project.customer.domain.Customer;

import java.util.List;

/**
 * 持久层--sql--mapper.xml
 *
 * @author 蒲万徐
 */
public interface CustomerMapper {
    /**
     * 1.查询客户
     *
     * @return int
     */
    List<Customer> findCustomer();

    /**
     * 2.添加客户
     *
     * @param customer
     * @return int
     */
    int addCustomer(Customer customer);

    /**
     * 3.修改客户
     *
     * @param customer
     * @return int
     */
    int updateCustomer(Customer customer);

    /**
     * 4.修改客户
     *
     * @param id
     * @return int
     */
    int deleteCustomer(int id);

    /**
     * 5.设置客户状态
     */
    int setCusState(int id, int state);

}
