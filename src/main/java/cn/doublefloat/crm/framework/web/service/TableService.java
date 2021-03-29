package cn.doublefloat.crm.framework.web.service;

import cn.doublefloat.crm.common.ServletUtils;
import cn.doublefloat.crm.common.StringUtils;
import cn.doublefloat.crm.framework.web.domain.Page;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 7:27 下午
 */

public class TableService {
    private TableService() {
    }

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 封装分页对象
     */
    public static Page getPageDomain() {
        Page pageDomain = new Page();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(PAGE_SIZE));
        pageDomain.setOrderByColumn(StringUtils.isEmpty(ServletUtils.getParameter(ORDER_BY_COLUMN)) ? "createTime" : ServletUtils.getParameter(ORDER_BY_COLUMN));
        pageDomain.setIsAsc(StringUtils.isEmpty(ServletUtils.getParameter(IS_ASC)) ? "desc" : ServletUtils.getParameter(IS_ASC));
        return pageDomain;
    }

    public static Page buildPageRequest() {
        return getPageDomain();
    }
}
