package cn.doublefloat.crm.project.customer.controller;

import cn.doublefloat.crm.framework.web.controller.BaseController;
import cn.doublefloat.crm.framework.web.domain.JsonResult;
import cn.doublefloat.crm.project.customer.domain.SalesChance;
import cn.doublefloat.crm.project.customer.service.SalesChanceService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;


/**
 * TODO
 *
 * @author 仇武元
 * @version 1.0
 * @date 2021/3/26 11:25 下午
 */
@Api
@RestController
@RequestMapping("/SalesChance")
public class SalesChanceController extends BaseController {
    @Resource
    private SalesChanceService saleschanceService;

    @GetMapping("/findSalesChance")
    public String findSalesChance() {
        startPage();
        return "";
    }

    /**
     * 增加接口
     *
     * @param salesChance
     * @return
     */
    @PostMapping("/insert")
    public JsonResult insertChance(SalesChance salesChance) {
        salesChance.setCreate_date(new Timestamp(System.currentTimeMillis()));
        int res = saleschanceService.insertChance(salesChance);
        return toJson(res);
    }


    // 得到初始数据
    @GetMapping("/{id}")
    public JsonResult getBeginDate(@PathVariable("id") Integer id) {
        int res = 0;
        SalesChance salesChance = saleschanceService.getBeginDate(id);
        if (salesChance != null) {
            res = 1;
        }
        return toJson(res);
    }

    // 编辑(修改)营销机会
    @PutMapping("/edit/{id}")
    public JsonResult editChance(@PathVariable("id") Integer id, SalesChance salesChance) {
        salesChance.setId(id);
        int res = saleschanceService.editChance(salesChance);
        return toJson(res);
    }

    // 指派工作人员
    @PutMapping("/assign/{id}")
    public JsonResult assign(@PathVariable("id") Integer id, SalesChance salesChance) {
        salesChance.setId(id);
        salesChance.setStatus('1');
        salesChance.setDesignee_date(new Timestamp(System.currentTimeMillis()));
        int res = saleschanceService.assign(salesChance);
        return toJson(res);
    }

    // 删除营销机会
    @DeleteMapping("/delete/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        int res = saleschanceService.deleteChance(id);
        return toJson(res);
    }
}
