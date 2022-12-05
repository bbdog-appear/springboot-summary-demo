package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.rmi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：MyServletA.java Date：2022/12/5 18:50 Version：1.0
 */
public class MyServletA extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String message = "If you`re reading this, it worked";
        out.println("<HTML><BODY>");
        out.println("<H1>" + message + "</H1>");
        out.println("</BODY><HTML>");
        out.close();
    }
}
