package cn.doublefloat.crm.project.system.service;

import cn.doublefloat.crm.project.system.domain.Password;
import cn.doublefloat.crm.project.system.domain.User;
import cn.doublefloat.crm.project.system.domain.vo.UserVo;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 10:44 下午
 */

public interface UserService {

    /**
     * 查找所有用户
     *
     * @param user 条件
     * @return 结果
     */
    List<UserVo> findAll(User user);

    /**
     * 获取用户数量
     *
     * @param user 用户
     * @return 结果
     */
    Integer countAll(User user);

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    int saveUser(UserVo user);

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     * @return 结果
     */
    int delete(Long id);

    /**
     * 根据ID查询用户信息
     *
     * @param id ID
     * @return 结果
     */
    UserVo findById(Long id);

    /**
     * 根据登录名获取用户信息
     *
     * @param loginName 登录名
     * @return 结果
     */
    UserVo findByLoginName(String loginName);

    /**
     * 查询销售部用户
     *
     * @return 结果
     */
    List<Map<Long, Object>> findSalesAll();

    /**
     * 获取所有销售经理信息
     *
     * @return 结果
     */
    List<Map<Long, Object>> findAllManager();

    /**
     * 修改密码
     *
     * @param pwd 密码
     * @return 结果
     */
    int setPassword(Password pwd);
}
