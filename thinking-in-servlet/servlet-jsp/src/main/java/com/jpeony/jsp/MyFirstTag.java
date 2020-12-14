//package com.jpeony.jsp;
//
//import javax.servlet.jsp.JspContext;
//import javax.servlet.jsp.JspException;
//import javax.servlet.jsp.tagext.JspFragment;
//import javax.servlet.jsp.tagext.JspTag;
//import javax.servlet.jsp.tagext.SimpleTag;
//import java.io.IOException;
//
//public class MyFirstTag implements SimpleTag {
//    JspContext jspContext;
//
//    @Override
//    public void doTag() throws IOException, JspException {
//        System.out.println("doTag");
//        jspContext.getOut().print("This is my first tag.");
//    }
//
//    @Override
//    public void setParent(JspTag parent) {
//        System.out.println("setParent");
//    }
//
//    @Override
//    public JspTag getParent() {
//        System.out.println("getParent");
//        return null;
//    }
//
//    @Override
//    public void setJspContext(JspContext jspContext) {
//        System.out.println("setJspContext");
//        this.jspContext = jspContext;
//    }
//
//    @Override
//    public void setJspBody(JspFragment body) {
//        System.out.println("setJspBody");
//    }
//
//}
