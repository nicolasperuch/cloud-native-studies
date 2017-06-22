package com.ilegra.jt.servlet;

import com.ilegra.jt.calculator.Calculator;
import com.ilegra.jt.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value ="/")
public class Servlet extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = (Calculator) applicationContext.getBean("calculator");

        PrintWriter out = response.getWriter();

        out.println(calculator.doTheMath(2,10,"pow"));
        out.println(calculator.doTheMath(2,0,"div"));
        out.println(calculator.doTheMath(2,9,"pow"));
        out.println(calculator.doTheMath(2,5,"pow"));
        out.println(calculator.doTheMath(2,2,"div"));

    }

}
