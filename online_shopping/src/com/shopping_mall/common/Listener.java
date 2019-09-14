package com.shopping_mall.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class Listener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    //本方法会在Web程序部署成功后，立即执行。一般是用来对本程序中的数据做一些初始化工作
    @Override
    public void contextInitialized(ServletContextEvent event) {
        //放置web应用上下文根路径
        ServletContext context = event.getServletContext();
        String ctx = context.getContextPath(); //JSP页面的链接的基准路径

        //往ServletContext作用域里存放一个名为ctx的变量。
        context.setAttribute("ctx", ctx);

        //JSP页面中要显示的后台动态上传的图片的基准路径
        context.setAttribute("pic_url", ctx + "/img/");

    }
}
