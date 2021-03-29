package cn.doublefloat.crm.project.customer.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * @author 卢颢文
 */

public class Drains {
    /**
     * 自动生成id
     */
    private Long id;
    /**
     * 客户id
     */
    private Long customerId;
    /**
     * 流失状态（0,1,2）（流失预警 暂缓流失 确认流失）
     */
    private String status;
    /**
     * 暂缓流失计划
     */
    private String delay;
    /**
     * 流失原因
     */
    private String reason;
    /**
     * 流失时间
     */
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date drainDate;
    /**
     * 最后流失时间
     */
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date lastOrderDate;

    /**
     * get set 方法
     *
     * @return
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDrainDate() {
        return drainDate;
    }

    public void setDrainDate(Date drainDate) {
        this.drainDate = drainDate;
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    /**
     * toString 方法
     *
     * @return
     */
    @Override
    public String toString() {
        return "Drains{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", status='" + status + '\'' +
                ", delay='" + delay + '\'' +
                ", reason='" + reason + '\'' +
                ", drainDate=" + drainDate +
                ", lastOrderDate=" + lastOrderDate +
                '}';
    }
}
