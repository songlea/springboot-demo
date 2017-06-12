package com.songlea.springboot.demo.util;

import org.jasig.cas.client.authentication.AttributePrincipal;
import javax.servlet.http.HttpServletRequest;

/**
 * 取登录用户名，因使用cas暂不能取到整个用户信息
 *
 * @author Song Lea
 */
public final class SecurityUtils {

    public static final String TABLE_TOTAL = "total";
    public static final String TABLE_ROWS = "rows";

    private SecurityUtils() {
    }

    // 取登录用户的用户名,若不存在则返回null
    public static String getLoginUserName(HttpServletRequest httpServletRequest) {
        AttributePrincipal principal = (AttributePrincipal) httpServletRequest.getUserPrincipal();
        return principal != null ? principal.getName() : null;
    }

    // 若obj为null则返回0,否则返回Long类型
    public static Long convertObj2Long(Object obj) {
        return obj == null ? null : Long.valueOf(obj.toString());
    }

    // 若obj为null则返回null,否则返回Integer类型
    public static Integer convertObj2Integer(Object obj) {
        return obj == null ? null : Integer.valueOf(obj.toString());
    }

    // 分页查询数据的SQL
    public static String pagingQuerySql(String sql, int offset, int limit) {
        int number = offset + limit;
        return "select row_.* from (select rowStarit_.*,rownum rownumStarit from ( " + sql
                + " ) rowStarit_ where rownum <= " + number + " ) row_ where rownumStarit > " + offset;
    }

    // 分页查询总数的SQL
    public static String countQuerySql(String sql) {
        return "select count (1) from ( " + sql + ") ";
    }
}
