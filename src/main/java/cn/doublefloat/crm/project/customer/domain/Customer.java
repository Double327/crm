package cn.doublefloat.crm.project.customer.domain;

/**
 * 实体类
 *
 * @author 蒲万徐
 */
public class Customer {

    private Long id;
    private String name;
    /**
     * 地区
     */
    private String region;
    /**
     * 客户经理（用户ID）
     */
    private Long managerId;
    private String telephone;
    /**
     * 传真
     */
    private String fax;
    /**
     * 客户等级
     */
    private Integer level;
    /**
     * 客户满意度
     */
    private Integer satify;
    /**
     * 客户信任度
     */
    private Integer credit;
    /**
     * 客户状态（0真诚，1流失，2删除）
     */
    private String state;

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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSatify() {
        return satify;
    }

    public void setSatify(Integer satify) {
        this.satify = satify;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
