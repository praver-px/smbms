package com.praver.servlet.user;

import com.praver.pojo.User;
import com.praver.service.user.UserService;
import com.praver.service.user.UserServiceImpl;
import com.praver.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //Servlet：控制层，调用业务层代码

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        //与数据库中的数据进行对比，调用业务层
        UserService userService = new UserServiceImpl();
        User user = userService.Login(userCode, userPassword);//这里已经把登录的人查出来了
        if (user != null){//查到了
            //将用户放到session中
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            //登录成功后，跳转到主页
            resp.sendRedirect("jsp/frame.jsp");
        }else {//查无此人
            //转发回登录页面，并提示
            req.setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
