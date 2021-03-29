package cn.doublefloat.crm.project.system.domain;

import cn.doublefloat.crm.project.system.domain.vo.UserVo;

import java.util.Date;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 10:44 下午
 */

public class User {

    /**
     * ID
     */
    private Long id;

    /**
     * 登陆名
     */
    private String loginName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Date birth;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户类别
     */
    private Integer userType;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 所属机构
     */
    private Long organizationId;

    /**
     * 创建时间
     */
    private Date createTime;

    public User() {
    }

    public User(Long id, String loginName, String realName, String password, Integer sex, Date birth, String phone, Integer userType, Integer status, Long organizationId, Date createTime) {
        this.id = id;
        this.loginName = loginName;
        this.realName = realName;
        this.password = password;
        this.sex = sex;
        this.birth = birth;
        this.phone = phone;
        this.userType = userType;
        this.status = status;
        this.organizationId = organizationId;
        this.createTime = createTime;
    }

    public User(UserVo user) {
        this.loginName = user.getLoginName();
        this.realName = user.getRealName();
        this.password = user.getPassword();
        this.sex = user.getSex();
        this.birth = user.getBirth();
        this.phone = user.getPhone();
        this.userType = user.getUserType();
        this.status = user.getStatus();
        this.organizationId = user.getOrganizationId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
