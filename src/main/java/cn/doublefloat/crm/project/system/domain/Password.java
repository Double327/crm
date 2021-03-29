package cn.doublefloat.crm.project.system.domain;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 10:49 下午
 */

public class Password {

    private Long id;

    private String loginName;

    private String oldPassword;

    private String newPassword;

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

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
