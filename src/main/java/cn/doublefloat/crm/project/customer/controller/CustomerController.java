package cn.doublefloat.crm.project.customer.controller;

import cn.doublefloat.crm.framework.web.controller.BaseController;
import cn.doublefloat.crm.framework.web.domain.JsonResult;
import cn.doublefloat.crm.project.customer.domain.Customer;
import cn.doublefloat.crm.project.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//@Controller
//@ResponseBody

/**
 * 控制层
 *
 * @author 蒲万徐
 */
@RestController
@RequestMapping("/Customer")
public class CustomerController extends BaseController {

    @Resource
    private CustomerService customerService;

    /**
     * 1.查询所有
     */
    @GetMapping("/findCus")
    public JsonResult findCustomer() {
        int res = customerService.findCustomer();
        return toJson(res);
    }

    /**
     * 2.添加
     */
    @PostMapping("/addCus")
    public JsonResult addCustomer(Customer customer) {
        int res = customerService.addCustomer(customer);
        return toJson(res);
    }

    /**
     * 3.修改
     */
    @PutMapping("/updateCus")
    public JsonResult updateCustomer(Customer customer) {
        int res = customerService.updateCustomer(customer);
        return toJson(res);
    }

    /**
     * 4.删除
     */
    @DeleteMapping("/deleteCus/{id}")
    public JsonResult deleteCustomer(@PathVariable int id) {
        int res = customerService.deleteCustomer(id);
        return toJson(res);
    }

    /**
     * 5.设置状态
     */
    @PutMapping("/setCusState/{id}")
    public JsonResult setCusState(@PathVariable int id, int state) {
        int res = customerService.setCusState(id, state);

        return toJson(res);
    }
}
