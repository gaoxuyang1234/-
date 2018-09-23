package com.yxysoft.base.weixin;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.shw.vote.web.service.AuthService;

public class ServerPortal extends HttpServlet {
    //CODE：servlet
    private static final long serialVersionUID = 1L;
    //我们的Token
    private static final String token = "zhuhanlin";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerPortal() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        System.out.println("signature:" + signature);
        System.out.println("timestamp:" + timestamp);
        System.out.println("nonce:" + nonce);
        System.out.println("echostr:" + echostr);
        PrintWriter pw = response.getWriter();
        pw.append(echostr);
        pw.flush();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

   //spring boot需要注入servlet：
    @Bean
    public ServletRegistrationBean testServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServerPortal());
        //我们的URL
        registration.addUrlMappings("/portal");
        return registration;
    }

}