package cn.doublefloat.crm.project.customer.domain;
/**
 * 销售机会实体类
 */

import java.sql.Timestamp;

public class SalesChance {
    private Integer id; //id
    private String customer_name;//客户名称
    private String title;//概要
    private String contact;//联系人
    private String contact_tel;//联系人电话
    private Integer create_by;//创建人
    private Timestamp create_date;//创建时间
    private Integer designee;//指派人（用户ID）
    private String description;//机会描述
    private Character status;//状态(0.未分配1.已分配)
    private Timestamp designee_date;//指派时间

    /*get和set方法*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact_tel() {
        return contact_tel;
    }

    public void setContact_tel(String contact_tel) {
        this.contact_tel = contact_tel;
    }

    public Integer getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Integer create_by) {
        this.create_by = create_by;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Integer getDesignee() {
        return designee;
    }

    public void setDesignee(Integer designee) {
        this.designee = designee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Timestamp getDesignee_date() {
        return designee_date;
    }

    public void setDesignee_date(Timestamp designee_date) {
        this.designee_date = designee_date;
    }
}

