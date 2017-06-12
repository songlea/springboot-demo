package com.songlea.springboot.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.songlea.springboot.demo.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import com.songlea.springboot.demo.configure.OtherFileConfig;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 场景-使用freeMarker模板
 * 需要注意pom.xml中依赖
 *
 * @author Song Lea
 */
@Controller
@RequestMapping("/freemarker")
public class FreeMarkerHomeController {

    private OtherFileConfig otherFileConfig;

    public FreeMarkerHomeController() {
    }

    @Autowired
    public FreeMarkerHomeController(OtherFileConfig otherFileConfig) {
        // 构造器注入,在项目启动时进行依赖的非空检查,避免运行期间的空指针异常
        Assert.notNull(otherFileConfig, "FreeMarkerHomeController.otherFileConfig must be not null!");
        this.otherFileConfig = otherFileConfig;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Map<String, Object> map, HttpServletRequest request) {
        // 取登录用户编码
        String loginUserCode = SecurityUtils.getLoginUserName(request);
        map.put("loginUserCode", loginUserCode);
        // 从其他的配置文件中获取
        map.put("username", otherFileConfig.getUsername());
        map.put("password", otherFileConfig.getPassword());
        return "freemarker";
    }
}
