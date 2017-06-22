package com.github.adrielsoares.java.spring4.calculadora.Configuracao.Servlets;

import com.github.adrielsoares.java.spring4.calculadora.Configuracao.ConfiguracaoAPP;
import com.github.adrielsoares.java.spring4.calculadora.Configuracao.Operacoes.Calculo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ilegra0267 on 01/06/17.
 */

@WebServlet(value = "/servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse respon) throws ServletException, IOException {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfiguracaoAPP.class);
        Calculo calculador = (Calculo) applicationContext.getBean("calculo");

        PrintWriter out = respon.getWriter();

        out.println(calculador.calculo(1, 2, "+"));
        out.println(calculador.calculo(7, 6, "*"));
        out.println(calculador.calculo(4, 8, "+"));
        out.println(calculador.calculo(4, 0, "/"));
        out.println(calculador.calculo(7, 3, "-"));
        out.println(calculador.calculo(9, 3, "/"));
        out.println(calculador.calculo(5, 7, "+"));
        out.println(calculador.calculo(2, 4, "^"));

        out.println(calculador.getHistoricoMap());
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}

