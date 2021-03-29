package cn.doublefloat.crm.project.system.controller;

import cn.doublefloat.crm.framework.web.controller.BaseController;
import cn.doublefloat.crm.framework.web.domain.JsonResult;
import cn.doublefloat.crm.project.system.domain.Organization;
import cn.doublefloat.crm.project.system.domain.vo.OrganizationVo;
import cn.doublefloat.crm.project.system.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/29 4:57 下午
 */
@RestController
@RequestMapping("/organization")
public class OrganizationController extends BaseController {

    @Autowired
    private OrganizationService organizationService;


    @GetMapping("/getAll")
    public JsonResult findAll() {
        return JsonResult.success(organizationService.findAll());
    }

    @PostMapping("/")
    public JsonResult saveOrganization(Organization organization) {
        int i = organizationService.saveOrganization(organization);
        return toJson(i);
    }

    @GetMapping("/{id}")
    public JsonResult findById(@PathVariable Long id) {
        Organization org = organizationService.findById(id);
        return JsonResult.success(org);
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        int i = organizationService.delete(id);
        return toJson(i);
    }
}
