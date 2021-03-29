package cn.doublefloat.crm.project.customer.service.impl;

import cn.doublefloat.crm.project.customer.domain.Drains;
import cn.doublefloat.crm.project.customer.mapper.DrainsMapper;
import cn.doublefloat.crm.project.customer.service.DrainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author 卢颢文
 */
@Service
public class DrainsServiceImpl implements DrainsService {

    @Autowired
    private DrainsMapper drainsMapper;

    /**
     * 返回查询方法执行的行数
     *
     * @return
     */
    @Override
    public List<Drains> selectCustomer() {
        return drainsMapper.selectCustomer();
    }

    /**
     * 设置流失状态 暂缓状态（1）
     *
     * @param drains
     * @return
     */
    @Override
    public int waitDrains(Drains drains) {
        drains.setStatus("1");
        drains.setLastOrderDate(new Date());
        int nums = drainsMapper.updateCustomer(drains);
        return nums;

    }

    /**
     * 设置流失状态 确认流失（2）
     *
     * @param drains
     * @return
     */
    @Override
    public int okDrains(Drains drains) {
        drains.setStatus("2");
        drains.setDrainDate(new Date());
        drains.setLastOrderDate(new Date());
        return drainsMapper.updateCustomer(drains);
    }

    /**
     * 插入顾客信息
     *
     * @param drains
     * @return
     */
    @Override
    public int insertCustomer(Drains drains) {
        int nums = drainsMapper.insertCustomer(drains);
        return nums;
    }

    /**
     * 按照id查询顾客
     *
     * @param id
     * @return
     */
    @Override
    public Drains selectCustomerbyId(int id) {
        return drainsMapper.selectCustomerbyId(id);
    }

}
