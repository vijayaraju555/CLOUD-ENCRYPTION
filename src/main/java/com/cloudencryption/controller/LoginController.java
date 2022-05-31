package com.cloudencryption.controller;

import com.cloudencryption.model.User;
import com.cloudencryption.service.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserDaoImpl userManager;

    @RequestMapping("/")
    private String home() {
        return "index.html";
    }

    @RequestMapping("/login")
    private String login(HttpServletRequest req) {
        // here we are checking the user and logging in the user
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String pwd = req.getParameter("password");
        try {
            if (userManager.checkUser(email, pwd)) {
                session.setAttribute("id9", userManager.getUserByEmail(email).getUid()); // here we are getting the user
                                                                                         // by id and then using that id
                session.setAttribute("pemail", email);
                return "userhome.jsp";
            } else {
                session.setAttribute("msg", "Invalid Credentials Please Try Again");
                return "userlog.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "index.html";
        }
    }

    @RequestMapping("/register")
    private String register(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // here we are registering the user
        HttpSession session = req.getSession();
        String name = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String gen = req.getParameter("gen");
        String address = req.getParameter("aname");
        if (userManager.checkUser(email, pwd)) {
            session.setAttribute("msg", "User Exists With Email and password please login");
            return "userreg.jsp";
        } else {
            User user = new User(name, pwd, email, phone, gen, address);
            userManager.addUser(user);
            session.setAttribute("msg", "Registration Successful");
            return "userlog.jsp";
        }
    }
}
