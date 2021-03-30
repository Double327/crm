package cn.doublefloat.crm.project.customer.domain;

import java.util.Date;

/**
 * 销售计划实体类
 *
 * @author 仇武元
 */
public class SalesPlan {
    /**
     * id
     */
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
     * toString()方法
     */
    @Override
    public String toString() {
        return "SalesPlan{" +
                "id=" + id +
                ", salesChanceId=" + salesChanceId +
                ", date=" + date +
                ", planContent='" + planContent + '\'' +
                ", status='" + status + '\'' +
                '}';
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
