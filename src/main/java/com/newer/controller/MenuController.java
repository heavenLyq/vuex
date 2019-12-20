package com.newer.controller;

import com.newer.pojo.Menu;
import com.newer.pojo.MenuUser;
import com.newer.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class MenuController {
    @Autowired
    private MenuService service;

    @RequestMapping("/loadMenu")
    @ResponseBody
    public List<MenuUser>loadMenu(@RequestParam("id") Integer id){
        List<MenuUser> menuUserList = new ArrayList<>();

        //1.根据用户id查询该用户的所有菜单
        List<Integer> menuIdList =service.loadMenuByUser(id);

        //2.查询所有的一级菜单
        List<Menu> topMenuList =   service.loadTopMenu();

        for(Menu topMenu:topMenuList){
            MenuUser menuUser = new MenuUser();
            //判断该用户对一级菜单是否有权限
            if(menuIdList.contains(topMenu.getId())){
                menuUser.setTopMenu(topMenu); //设置一级菜单

                //3.根据一级菜单查询二级菜单
                List<Menu> childMenuList = service.loadChildMenu(topMenu.getId());
                //存放二级菜单:
                List<Menu> realMenuList = new ArrayList<>();
                for(Menu childMenu:childMenuList){
                    if(menuIdList.contains(childMenu.getId())){
                        realMenuList.add(childMenu);
                    }
                }
                menuUser.setChildMenu(realMenuList); //设置二级菜单
                menuUserList.add(menuUser);
            }
        }
        return menuUserList;

    }

}
