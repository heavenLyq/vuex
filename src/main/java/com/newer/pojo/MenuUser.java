package com.newer.pojo;


import java.io.Serializable;
import java.util.List;

public class MenuUser implements Serializable {

    private static final long serialVersionUID = 2375074599669899360L;

    private Menu topMenu;
    private List<Menu>childMenu;
    public Menu getTopMenu() {
        return topMenu;
    }

    public void setTopMenu(Menu topMenu) {
        this.topMenu = topMenu;
    }

    public List<Menu> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<Menu> childMenu) {
        this.childMenu = childMenu;
    }



}
