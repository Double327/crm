package cn.doublefloat.crm.project.customer.service.impl;

import cn.doublefloat.crm.project.customer.domain.Customer;
import cn.doublefloat.crm.project.customer.mapper.CustomerMapper;
import cn.doublefloat.crm.project.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 实现层
 *
 * @author 蒲万徐
 */

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    /**
     * 1.查询
     */
    @Override
    public int findCustomer() {
        List<Customer> list = customerMapper.findCustomer();
        int res = 0;
        if (list != null) {
            // list中有数据了
            res = 1;
        }
        return res;

    }

    /**
     * 添加
     *
     * @param customer 信息
     * @return 结果
     */
    @Override
    public int addCustomer(Customer customer) {
        int res = customerMapper.addCustomer(customer);
        return res;
    }

    /**
     * 3.修改
     *
     * @param customer
     */
    @Override
    public int updateCustomer(Customer customer) {
        int res = customerMapper.updateCustomer(customer);
        return res;
    }

    /**
     * 4.删除
     *
     * @param id
     */
    @Override
    public int deleteCustomer(int id) {
        int res = customerMapper.deleteCustomer(id);
        return res;
    }

    /**
     * 5.设置状态
     */
    @Override
    public int setCusState(int id, int state) {
        int res = customerMapper.setCusState(id, state);
        return res;
    }

}
