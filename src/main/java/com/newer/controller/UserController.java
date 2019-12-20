package com.newer.controller;

import com.newer.pojo.User;
import com.newer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
@Controller
public class UserController {
    @Autowired
   private UserService service;


    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("nsjnjsnj");
        CustomDateEditor editor = new CustomDateEditor(df, true);//true表示允许为空，false反之
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping("init")
    public String init(){
        System.out.println("hellow");
        return "hellow";
    }

   @RequestMapping("queryUser")
   @ResponseBody
   public boolean login(@RequestParam("username")String username,
     @RequestParam("password")String password ,HttpSession session)
   {
       System.out.println(password+","+username);
    boolean flag=false;
     User user=service.login(username,password);
     if(Objects.nonNull(user)){
         session.setAttribute("user",user);
         flag=true;
     }
       return flag;
   }
    @RequestMapping("/getUserInfo")
    @ResponseBody
   public User getUserInfo(HttpSession session){
       User user=(User)session.getAttribute("user");
       if(Objects.nonNull(user)){
           user.setPassword(null);
       }
       return user;
   }






}
