package cn.doublefloat.crm.project.system.domain.vo;

import cn.doublefloat.crm.project.system.domain.Organization;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/29 4:51 下午
 */

public class OrganizationVo {
    private Long id;

    /**
     * 组织名
     */
    private String name;

    /**
     * 地址
     */
    private String address;

    /**
     * 编号
     */
    private String code;

    /**
     * 图标
     */
    private String iconCls;

    /**
     * 父级主键
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private String createTime;

    private List<OrganizationVo> children;

    public OrganizationVo() {
    }

    public OrganizationVo(Organization org) {
        this.id = org.getId();
        this.name = org.getName();
        this.address = org.getAddress();
        this.code = org.getCode();
        this.iconCls = org.getIcon();
        this.parentId = org.getParentId();
        this.sort = org.getSort();
        if (org.getCreateTime() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            this.createTime = sdf.format(org.getCreateTime());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<OrganizationVo> getChildren() {
        return children;
    }

    public void setChildren(List<OrganizationVo> children) {
        this.children = children;
    }
}
