package cn.doublefloat.crm.project.system.domain.vo;

import cn.doublefloat.crm.project.system.domain.Resource;

import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 8:01 下午
 */

public class ResourceVo {
    private Long id;
    /**
     * 资源名称
     */
    private String text;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 资源图标
     */
    private String iconCls;

    /**
     * 父级资源id
     */
    private Long parentId;

    /**
     * 打开的
     */
    private Boolean expanded;

    private List<ResourceVo> children;

    @Override
    public String toString() {
        return "ResourceVo{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parentId=" + parentId +
                ", expanded=" + expanded +
                '}';
    }

    public ResourceVo(Resource resource) {
        this.id = resource.getId();
        this.text = resource.getName();
        this.url = resource.getUrl();
        this.iconCls = resource.getIcon();
        this.parentId = resource.getParentId();
        if (resource.getOpened() == 1) {
            this.expanded = false;
        } else {
            this.expanded = true;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public List<ResourceVo> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceVo> children) {
        this.children = children;
    }
}
