package cn.doublefloat.crm.framework.web.controller;

import cn.doublefloat.crm.framework.web.domain.JsonResult;
import cn.doublefloat.crm.framework.web.domain.Page;
import cn.doublefloat.crm.framework.web.domain.TableResult;
import cn.doublefloat.crm.framework.web.service.TableService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 9:44 上午
 */

public class BaseController {

    protected JsonResult toJson(int res) {
        return res > 0 ? JsonResult.success() : JsonResult.error();
    }

    protected TableResult getDataTable(List<?> list) {
        TableResult rspData = new TableResult();
        rspData.setCode(HttpStatus.OK.value());
        rspData.setRows(list);
        if (list == null) {
            list = new ArrayList<>();
        }
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    protected void startPage() {
        Page pageDomain = TableService.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (pageNum != null && pageSize != null) {
            String orderBy = pageDomain.getOrderBy();
            PageMethod.startPage(pageNum, pageSize, orderBy);
        }
    }
}
