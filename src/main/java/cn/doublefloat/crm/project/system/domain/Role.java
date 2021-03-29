package cn.doublefloat.crm.project.system.domain;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 7:52 下午
 */

public class Role {

    private Long id;

    private String name;

    private Integer sort;

    private String description;

    private String status;

    public Role() {
    }

    public Role(Long id, String name, Integer sort, String description, String status) {
        this.id = id;
        this.name = name;
        this.sort = sort;
        this.description = description;
        this.status = status;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
