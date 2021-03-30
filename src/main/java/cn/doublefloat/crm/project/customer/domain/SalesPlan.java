package cn.doublefloat.crm.project.customer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 销售计划实体类
 *
 * @author 仇武元
 */
@Entity
public class SalesPlan {
    /**
     * id
     */
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Integer id;
    /**
     * 营销机会ID
     */
    private Integer salesChanceId;
    /**
     * 计划实施时间
     */
    private Date date;
    /**
     * 计划内容
     */
    private String planContent;
    /**
     * 计划执行结果(0.未执行1.执行中2.开发成功3.开发失败 )
     */
    private String status;
    /**
     * 联系人
     */
    private String contactName;
    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 电话
     */
    private String contactTel;

    /**
     * toString()方法
     */
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    /**
     * get和set方法
     *
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalesChanceId() {
        return salesChanceId;
    }

    public void setSalesChanceId(Integer salesChanceId) {
        this.salesChanceId = salesChanceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
