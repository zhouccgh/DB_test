package com.db.sys.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.common.vo.JsonResult;
import com.db.common.vo.Node;
import com.db.sys.entity.SysMenu;
import com.db.sys.service.SysMenuService;

@Controller
@RequestMapping("/menu/")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;
	@RequestMapping("doMenuListUI")
	public String doMenuListUI(){
		return "sys/menu_list";
	}
	
	@RequestMapping("doMenuEditUI")
	public String doMenuEditUI(){
		return "sys/menu_edit";
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysMenu entity){
		int rows=sysMenuService.updateObject(entity);
		return new JsonResult("update ok,rows="+rows);
	}
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysMenu entity){
		int rows=sysMenuService.saveObject(entity);
		return new JsonResult("save ok,rows="+rows);
	}
	
	@RequestMapping("doFindZtreeMenuNodes")
	@ResponseBody
	public JsonResult doFindZtreeMenuNodes(){
		List<Node> list=sysMenuService.findZtreeMenuNodes();
		System.out.println(list);//假如有乱码?
		return new JsonResult(list);
	}
	
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(){
		return new JsonResult(sysMenuService.findObjects());
	}
	
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id){
		sysMenuService.deleteObject(id);
		return new JsonResult("delete ok");
	}
}












