package cn.doublefloat.crm.project.customer.controller;


import cn.doublefloat.crm.framework.web.controller.BaseController;
import cn.doublefloat.crm.framework.web.domain.JsonResult;
import cn.doublefloat.crm.project.customer.domain.Drains;
import cn.doublefloat.crm.project.customer.service.DrainsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author 卢颢文
 */
@RestController
public class DrainsController extends BaseController {

    @Resource
    private DrainsService drainsService;

    /**
     * 查询所有顾客
     *
     * @param
     * @return
     */
    @GetMapping("/selectAll")
    public JsonResult selectCustomer() {
        if (drainsService.selectCustomer() != null) {
            return JsonResult.success("1", drainsService.selectCustomer());
        } else {
            return toJson(0);
        }
    }


    /**
     * 改变流失状态（暂缓流失）
     *
     * @param drains
     * @return
     */
    @PutMapping(value = "/waitDrains")
    public JsonResult waitDrains(Drains drains) {
        int res = 0;
        res = drainsService.waitDrains(drains);
        return toJson(res);
    }

    /**
     * 改变流失状态（确认流失）
     *
     * @param Drains
     * @return
     */
    @PutMapping(value = "/okDrains")
    public JsonResult okDrains(Drains Drains) {
        int res = 0;
        res = drainsService.okDrains(Drains);
        return toJson(res);

    }

    /**
     * 插入流失顾客信息
     *
     * @param drains
     * @return
     */
    @PutMapping(value = "/insertDrains")
    public JsonResult insertDrains(Drains drains) {
        int res = 0;
        res = drainsService.insertCustomer(drains);
        return toJson(res);
    }

    /**
     * 按照id查询流失顾客信息
     *
     * @param id
     * @return
     */
    @GetMapping("/selectbyId/{id}")
    public JsonResult selectCustomerbyId(@PathVariable("id") int id) {
        int res = 0;
        if (drainsService.selectCustomerbyId(id) != null) {
            return JsonResult.success(drainsService.selectCustomerbyId(id));
        } else {
            return toJson(0);
        }
    }
}
