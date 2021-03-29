package cn.doublefloat.crm.project.system.domain.vo;

import cn.doublefloat.crm.project.system.domain.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 8:13 下午
 */

public class UserVo {

    private Long id;

    private String loginName;

    private String realName;

    private String password;

    private Integer sex;

    private Date birth;

    private Integer userType;

    private Integer status;

    private Long organizationId;

    private String createTime;

    private String phone;

    private Boolean isAdmin;

    private String organizationName;

    private List<Long> roleIds;

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", userType=" + userType +
                ", status=" + status +
                ", organizationId=" + organizationId +
                ", createTime='" + createTime + '\'' +
                ", phone='" + phone + '\'' +
                ", isAdmin=" + isAdmin +
                ", organizationName='" + organizationName + '\'' +
                ", roleIds=" + roleIds +
                '}';
    }

    public UserVo() {
    }

    public UserVo(User user) {
        this.id = user.getId();
        this.loginName = user.getLoginName();
        this.realName = user.getRealName();
        this.password = user.getPassword();
        this.sex = user.getSex();
        this.birth = user.getBirth();
        this.userType = user.getUserType();
        this.status = user.getStatus();
        this.organizationId = user.getOrganizationId();
        if (user.getCreateTime() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            this.createTime = sdf.format(user.getCreateTime());
        }
        this.phone = user.getPhone();
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}
