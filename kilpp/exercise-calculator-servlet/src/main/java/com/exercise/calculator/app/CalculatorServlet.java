package com.exercise.calculator.app;
import com.exercise.calculator.configuration.AppConfig;
import com.exercise.calculator.model.Calculator;
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
public class CalculatorServlet extends HttpServlet {
    protected void service(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = (Calculator) applicationContext.getBean("calculator");
        out.println("<title>CALCULATOR</title>");
        out.println("</br>" + calculator.doCalculation(3, "/", 0));
        out.println("</br>" + calculator.getMapHistory().getMapHistory());
        out.println("</br>" + calculator.doCalculation(3, "/", 0));
        out.println("</br>" + calculator.doCalculation(3, "/", 9));
        out.println("</br>" + calculator.doCalculation(3, "+", 9));
        out.println("</br>" + calculator.doCalculation(3, "-", 9));
        out.println("</br>" + calculator.doCalculation(3, "*", 9));
        out.println("</br>" + calculator.doCalculation(3, "^", 9));
        out.println("</br>" + calculator.doCalculation(3, "a", 9));
        out.println("</br>" + calculator.getMapHistory().getMapHistory());
    }
}



