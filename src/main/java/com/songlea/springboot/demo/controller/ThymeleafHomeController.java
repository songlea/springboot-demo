package com.songlea.springboot.demo.controller;

import com.songlea.springboot.demo.util.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 场景-使用Thymeleaf模板
 * SpringBoot推荐使用Thymeleaf作为模板引擎，因为Thymeleaf提供了完美的SpringMVC支持
 * 需要注意pom.xml中依赖
 *
 * @author Song Lea
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafHomeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("thymeleaf");
        modelAndView.addObject("loginUserCode", SecurityUtils.getLoginUserName(request));
        return modelAndView;
    }
}
