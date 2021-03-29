package cn.doublefloat.crm.project.system.controller;

import cn.doublefloat.crm.framework.web.controller.BaseController;
import cn.doublefloat.crm.framework.web.domain.JsonResult;
import cn.doublefloat.crm.framework.web.domain.TableResult;
import cn.doublefloat.crm.project.system.domain.Resource;
import cn.doublefloat.crm.project.system.domain.User;
import cn.doublefloat.crm.project.system.domain.vo.ResourceListVo;
import cn.doublefloat.crm.project.system.domain.vo.ResourceRightVo;
import cn.doublefloat.crm.project.system.domain.vo.UserVo;
import cn.doublefloat.crm.project.system.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/28 3:15 下午
 */

@RestController
@RequestMapping("/resource")
public class ResourceController extends BaseController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/getResource")
    public JsonResult findResource() {
        UserVo userVo = new UserVo();
        ArrayList<Long> ids = new ArrayList<Long>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        userVo.setRoleIds(ids);
        userVo.setAdmin(true);
        return JsonResult.success(resourceService.findResource(userVo));
    }

    @GetMapping("/getResourceList")
    public TableResult findResourceList() {
        List<ResourceListVo> resourceVos = resourceService.findResourceList();
        return getDataTable(resourceVos);
    }

    @GetMapping("/findRightList")
    public JsonResult findRightList(Long id) {
        List<ResourceRightVo> resourceVos = resourceService.findRightList(id);
        return JsonResult.success(resourceVos);
    }

    @PostMapping("/")
    public JsonResult saveResource(Resource res) {
        int i = 0;
        try {
            i = resourceService.saveResource(res);
        } catch (Exception e) {
            return JsonResult.error(e.getMessage());
        }
        return toJson(i);
    }

    @GetMapping("/{id}")
    public JsonResult findById(@PathVariable Long id) {
        Resource resource = null;
        try {
            resource = resourceService.findById(id);
        } catch (Exception e) {
            return JsonResult.error(e.getMessage());
        }
        return JsonResult.success(resource);
    }

    @DeleteMapping(value = "/{ids}")
    public JsonResult deleteResource(@PathVariable Long[] ids) {
        int i = 0;
        try {
            i = resourceService.deleteResource(ids);
        } catch (Exception e) {
            return JsonResult.error(e.getMessage());
        }
        return toJson(i);
    }
}
