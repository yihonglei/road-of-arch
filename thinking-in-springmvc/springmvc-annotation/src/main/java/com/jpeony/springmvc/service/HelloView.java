package com.jpeony.springmvc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

/**
 * 说明，@Component:把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
 *
 * @author yihonglei
 */
@Component
public class HelloView implements View {

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request,
                       HttpServletResponse response) throws Exception {
        //==========================乱码问题解决==========================
        //1.让浏览器用UTF-8解析返回数据
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //2.让servlet用UTF-8转码
        response.setCharacterEncoding("UTF-8");

        response.getWriter().print("hello view: 自定义视图解析器测试");
    }

}
