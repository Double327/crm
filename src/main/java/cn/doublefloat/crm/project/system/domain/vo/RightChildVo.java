package cn.doublefloat.crm.project.system.domain.vo;

import cn.doublefloat.crm.project.system.domain.Resource;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 8:07 下午
 */

public class RightChildVo {

    private Long id;
    private String name;
    private String action;
    private Long parentId;
    private Boolean checked;

    public RightChildVo(Resource resource) {
        this.id = resource.getId();
        this.name = resource.getName();
        if ("新增".equalsIgnoreCase(resource.getName())) {
            this.action = "add";
        } else if ("删除".equalsIgnoreCase(resource.getName())) {
            this.action = "remove";
        } else if ("编辑".equalsIgnoreCase(resource.getName())) {
            this.action = "edit";
        } else if ("列表".equalsIgnoreCase(resource.getName())) {
            this.action = "list";
        } else if ("授权".equalsIgnoreCase(resource.getName())) {
            this.action = "right";
        } else {
            this.action = "";
        }
        this.parentId = resource.getParentId();
        this.checked = false;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
