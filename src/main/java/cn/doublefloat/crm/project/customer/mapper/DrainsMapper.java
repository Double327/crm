package cn.doublefloat.crm.project.customer.mapper;


import cn.doublefloat.crm.project.customer.domain.Drains;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 卢颢文
 */
@Repository
public interface DrainsMapper {
    /**
     * 查询所有流失顾客
     */
    List<Drains> selectCustomer();

    /**
     * 修改流失顾客状态信息
     */
    int updateCustomer(Drains drains);

    /**
     * 增加流失客户
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
