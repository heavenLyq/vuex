package com.newer.dao;

import com.newer.pojo.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuMapper {
    //查询该用户下的所有菜单
    @Select("select distinct mr.menu_id from roles r ,user_role ur," +
            "menu_role mr where r.id=ur.role_id and r.id=mr.role_id " +
            "and ur.user_id=#{id}")
    public List<Integer>loadMenuByUser(@Param("id")Integer id);


    @Select("select * from menus where parent_id is null order by seq")

    public  List<Menu> loadTopMenu();

    @Select("select * from menus where parent_id=#{pid} order by seq")

    public List<Menu> loadChildMenu(@Param("pid") Integer id);


}
