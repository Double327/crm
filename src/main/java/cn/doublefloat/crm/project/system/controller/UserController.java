package cn.doublefloat.crm.project.system.controller;

import cn.doublefloat.crm.framework.web.controller.BaseController;
import cn.doublefloat.crm.framework.web.domain.JsonResult;
import cn.doublefloat.crm.framework.web.domain.TableResult;
import cn.doublefloat.crm.project.system.domain.Password;
import cn.doublefloat.crm.project.system.domain.User;
import cn.doublefloat.crm.project.system.domain.vo.UserVo;
import cn.doublefloat.crm.project.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/28 4:19 下午
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public TableResult findAll(User user) {
        List<UserVo> users = userService.findAll(user);
        return getDataTable(users);
    }

    @GetMapping("/{id}")
    public JsonResult findById(@PathVariable Long id) {
        UserVo user = userService.findById(id);
        return JsonResult.success(user);
    }


    @GetMapping("/findAllCustomerManager")
    public JsonResult findAllManager() {
        List<Map<Long, Object>> allManager = userService.findAllManager();
        return JsonResult.success(allManager);
    }

    @PostMapping("/")
    public JsonResult saveUser(UserVo user) {
        int i = userService.saveUser(user);
        return toJson(i);
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        int i = userService.delete(id);
        return toJson(i);
    }

    @GetMapping("/findSalesAll")
    public JsonResult findSalesAll() {
        List<Map<Long, Object>> users = userService.findSalesAll();
        return JsonResult.success(users);
    }


    @PutMapping("/resetPwd")
    public JsonResult setPwd(Password pwd) {
        return toJson(userService.setPassword(pwd));
    }
}
