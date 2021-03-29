package cn.doublefloat.crm.project.system.controller;

import cn.doublefloat.crm.framework.web.controller.BaseController;
import cn.doublefloat.crm.framework.web.domain.JsonResult;
import cn.doublefloat.crm.framework.web.domain.TableResult;
import cn.doublefloat.crm.project.system.domain.Role;
import cn.doublefloat.crm.project.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/28 5:49 下午
 */

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/getRoleList")
    public TableResult findRoleList(Role role) {
        List<Role> roleList = roleService.findRoleList(role);
        return getDataTable(roleList);
    }

    @GetMapping("/getAll")
    public JsonResult getAll(Role role) {
        List<Role> roles = roleService.getAll(role);
        return JsonResult.success(roles);
    }


    @PostMapping("/save")
    public JsonResult saveRole(Role role) {
        int i = roleService.saveRole(role);
        return toJson(i);
    }

    @GetMapping("/{id}")
    public JsonResult findById(@PathVariable Long id) {
        return JsonResult.success(roleService.findById(id));
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        int i = roleService.delete(id);
        return toJson(i);
    }

    @PostMapping("/saveRightList")
    public JsonResult saveRightList(Long[] ids, Long roleId) {
        int i = roleService.saveRightList(ids, roleId);
        return toJson(i);
    }
}
