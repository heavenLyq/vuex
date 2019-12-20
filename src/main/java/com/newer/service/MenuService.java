package com.newer.service;

import com.newer.dao.MenuMapper;
import com.newer.pojo.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class MenuService  {
    @Autowired
    private MenuMapper menuMapper;

    public List<Integer>loadMenuByUser(Integer id){
        return menuMapper.loadMenuByUser(id);
    }

    public List<Menu>loadTopMenu(){
        return menuMapper.loadTopMenu();
    }

    public List<Menu>loadChildMenu(Integer id){
        return menuMapper.loadChildMenu(id);
    }
}
