package com.songlea.springboot.demo.controller;

import com.songlea.springboot.demo.util.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 场景-使用groovy模板
 * 参考:http://docs.groovy-lang.org/latest/html/documentation/#_the_markuptemplateengine
 * 需要注意pom.xml中依赖
 *
 * @author Song Lea
 */
@Controller
@RequestMapping("/groovy")
public class GroovyHomeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("groovy");
        modelAndView.addObject("loginUserCode", SecurityUtils.getLoginUserName(request));
        modelAndView.addObject("request", request);
        modelAndView.addObject("response", response);
        return modelAndView;
    }
}
