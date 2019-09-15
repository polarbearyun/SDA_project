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
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        String ctx = context.getContextPath();//To get the right path of project.
        context.setAttribute("ctx", ctx);
    }
}
