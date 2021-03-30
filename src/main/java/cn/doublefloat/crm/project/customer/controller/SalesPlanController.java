package cn.doublefloat.crm.project.customer.controller;

import cn.doublefloat.crm.framework.web.controller.BaseController;
import cn.doublefloat.crm.framework.web.domain.JsonResult;
import cn.doublefloat.crm.project.customer.domain.SalesPlan;
import cn.doublefloat.crm.project.customer.service.SalesPlanService;
 import cn.doublefloat.crm.project.customer.service.impl.SalesPlanImpl;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 销售机会表
 * @author 仇武元
 */

@Api
@RestController
@RequestMapping("/SalesPlan")
public class SalesPlanController extends BaseController {
    @Resource
    private SalesPlanImpl salesPlanService;

    /**
     * 查询所有营销计划
     */
    @GetMapping("/findAllPlans")
    public JsonResult findAllPlans(){
        JsonResult result = null;
        salesPlanService.insertDate();
        List<SalesPlan> salesPlanList = salesPlanService.findAll();
        if(salesPlanList != null){
            result = JsonResult.success("查询成功", salesPlanList);
        }
        return result;
    }

    /**
     * 执行开发
     * @param id
     * @param salesPlan
     * @return toJson(res)
     */
    @PutMapping("/start/{id}")
    public JsonResult startPlan(@PathVariable("id") Integer id, SalesPlan salesPlan){
        salesPlan.setDate(new Date());
        salesPlan.setId(id);
        salesPlan.setStatus("1");
        int res = salesPlanService.startPlan(salesPlan);
        return toJson(res);
    }

    /**
     * 开发成功
     * @param id
     * @param salesPlan
     * @return toJson(res)
     */
    @PutMapping("/success/{id}")
    public JsonResult changeStatusSuccess(@PathVariable("id") Integer id,SalesPlan salesPlan){
        salesPlan.setId(id);
        salesPlan.setStatus("2");
        int res = salesPlanService.changeStatus(salesPlan);
        return toJson(res);
    }

    /**
     * 开发失败
     * @param id
     * @param salesPlan
     * @return toJson(res)
     */
    @PutMapping("/lose/{id}")
    public JsonResult changeStatusLose(@PathVariable("id") Integer id,SalesPlan salesPlan){
        salesPlan.setId(id);
        salesPlan.setStatus("3");
        int res = salesPlanService.changeStatus(salesPlan);
        return toJson(res);
    }
}
