package cn.doublefloat.crm.project.customer.domain;

import java.sql.Timestamp;

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

    private Integer sales_chance_id; //营销机会ID
    private Timestamp date; //计划实施时间
    private String plan_content; //计划内容
    private Character status;// 计划执行结果(0.未执行1.执行中2.开发成功3.开发失败 )


    /*get和set方法*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSales_chance_id() {
        return sales_chance_id;
    }

    public void setSales_chance_id(Integer sales_chance_id) {
        this.sales_chance_id = sales_chance_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getPlan_content() {
        return plan_content;
    }

    public void setPlan_content(String plan_content) {
        this.plan_content = plan_content;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
