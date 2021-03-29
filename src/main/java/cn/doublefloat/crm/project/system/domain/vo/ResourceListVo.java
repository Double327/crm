package cn.doublefloat.crm.project.system.domain.vo;

import cn.doublefloat.crm.project.system.domain.Resource;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 8:09 下午
 */

public class ResourceListVo {

    private Long id;
    private String name;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 资源图标
     */
    @JsonProperty("iconCls")
    private String icon;

    /**
     * 父级资源id
     */
    private Long pid;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态
     */
    private String status;

    /**
     * 资源类别
     */
    private String resourceType;

    private List<ResourceListVo> children;

    public ResourceListVo(Resource resource) {
        this.id = resource.getId();
        this.name = resource.getName();
        this.url = resource.getUrl();
        this.icon = resource.getIcon();
        this.pid = resource.getParentId();
        this.sort = resource.getSort();
        this.status = resource.getStatus();
        if (resource.getResourceType() == 0) {
            this.resourceType = "菜单";
        } else {
            this.resourceType = "按钮";
        }
        this.children = new ArrayList<ResourceListVo>();
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getParentId() {
        return pid;
    }

    public void setParentId(Long pid) {
        this.pid = pid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public List<ResourceListVo> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceListVo> children) {
        this.children = children;
    }
}
