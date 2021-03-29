package cn.doublefloat.crm.project.system.domain.vo;

import cn.doublefloat.crm.project.system.domain.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 8:05 下午
 */

public class ResourceRightVo {
    private Long id;
    private String name;
    /**
     * 资源图标
     */
    private String icon;
    /**
     * 父级资源id
     */
    private Long parentId;
    private Integer resourceType;
    private List<RightChildVo> functions;

    public ResourceRightVo(Resource resource) {
        this.id = resource.getId();
        this.name = resource.getName();
        this.icon = resource.getIcon();
        this.parentId = resource.getParentId();
        this.resourceType = resource.getResourceType();
        this.functions = new ArrayList<RightChildVo>();
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<RightChildVo> getFunctions() {
        return functions;
    }

    public void setFunctions(List<RightChildVo> functions) {
        this.functions = functions;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
}
