package com.jpeony.springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yihonglei
 */
public class HelloWorldController implements Controller {
    private String helloWorld;
    private String viewPage;

    /**
     * 重写handleRequest()方法
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map model = new HashMap();
        model.put("helloWorld", getHelloWorld());
        return new ModelAndView(getViewPage(), model);
    }

    /**
     * 获取显示在页面中的文字
     */
    public String getHelloWorld() {
        return helloWorld;
    }

    /**
     * 注入页面中的文字
     */
    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

    /**
     * 获取要返回的页面
     */
    public String getViewPage() {
        return viewPage;
    }

    /**
     * 依赖注入要返回的页面
     */
    public void setViewPage(String viewPage) {
        this.viewPage = viewPage;
    }
}
