package cn.doublefloat.crm.project.system.domain;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 8:18 下午
 */

public class RoleResource {

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 资源ID
     */
    private Long resourceId;

    public RoleResource() {
    }

    public RoleResource(Long roleId, Long resourceId) {
        this.roleId = roleId;
        this.resourceId = resourceId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
