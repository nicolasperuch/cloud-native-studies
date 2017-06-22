package com.github.matheusbritzke.java.spring4.calculator.App;

import com.github.matheusbritzke.java.spring4.calculator.Calculator.Calculator;
import com.github.matheusbritzke.java.spring4.calculator.ConfigurationApp.WebConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class ServletApp extends HttpServlet{

    protected void service (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(WebConfig.class);
        Calculator useCalculator = (Calculator) applicationContext.getBean("calculator");

        PrintWriter printWriter = response.getWriter();

        printWriter.println(useCalculator.calculate(2, 2, "+"));
        printWriter.println(useCalculator.calculate(4, 3, "-"));
        printWriter.println(useCalculator.calculate(8, 2, "*"));
        printWriter.println(useCalculator.calculate(6, 2, "/"));
        printWriter.println(useCalculator.calculate(6, 0, "/"));
        printWriter.println(useCalculator.calculate(7, 4, "C"));
        printWriter.println(useCalculator.calculate(5, 2, "^"));
        printWriter.println(useCalculator.calculate(10, 2, "+"));
        printWriter.println(useCalculator.showHistoryByOperation("Invalid Operation"));
        printWriter.println(useCalculator.showHistoryByOperation("+"));
        printWriter.println(useCalculator.showHistory());
    }
}
