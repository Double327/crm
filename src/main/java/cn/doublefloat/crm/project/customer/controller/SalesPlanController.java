package cn.doublefloat.crm.project.customer.controller;

import cn.doublefloat.crm.framework.web.controller.BaseController;
import cn.doublefloat.crm.framework.web.domain.JsonResult;
import cn.doublefloat.crm.project.customer.domain.SalesPlan;
import cn.doublefloat.crm.project.customer.service.SalesPlanService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;

@RestController
@RequestMapping("/SalesPlan")
public class SalesPlanController extends BaseController {
    @Resource
    private SalesPlanService salesPlanService;
    //执行开发
    @PutMapping("/start/{id}")
    public JsonResult startPlan(@PathVariable("id") Integer id, SalesPlan salesPlan){
        salesPlan.setDate(new Timestamp(System.currentTimeMillis()));
        salesPlan.setId(id);
        salesPlan.setStatus('1');
        int res = salesPlanService.startPlan(salesPlan);
        return toJson(res);
    }

    //开发状态
    @PutMapping("/success/{id}")
    public JsonResult changeStatusSuccess(@PathVariable("id") Integer id,SalesPlan salesPlan){
        salesPlan.setId(id);
        salesPlan.setStatus('2');
        int res = salesPlanService.changeStatus(salesPlan);
        return toJson(res);
    }
    //开发失败
    @PutMapping("/lose/{id}")
    public JsonResult changeStatusLose(@PathVariable("id") Integer id,SalesPlan salesPlan){
        salesPlan.setId(id);
        salesPlan.setStatus('3');
        int res = salesPlanService.changeStatus(salesPlan);
        return toJson(res);
    }
}
