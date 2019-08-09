package com.db.sys.dao;

public interface SysRoleMenuDao {
	 /**
	  * 基于菜单id删除关系表数据
	  * @param menuId
	  * @return
	  */
	 int deleteObjectsByMenuId(Integer menuId);
}
