package com.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;

public class TestSysLogDao  extends TestBase{


	@Test
	public void testDeleteObjects(){
		SysLogDao dao=
				ctx.getBean("sysLogDao",SysLogDao.class);
		int rows=dao.deleteObjects(77,78,79,80);
		System.out.println(rows);
	}
	
	@Test
	public void testFindPageObjects(){
		SysLogDao dao=
		ctx.getBean("sysLogDao",SysLogDao.class);
        List<SysLog> list=dao.findPageObjects("admin",0,3);
		System.out.println(list.size());
	}
	
	@Test
	public void testGetRowCount(){
		SysLogDao dao=
		ctx.getBean("sysLogDao",SysLogDao.class);
		int rowCount=dao.getRowCount("admin");
		System.out.println(rowCount);
	}
	
	@Test
	public void testFindById(){
		SysLogDao dao=
		ctx.getBean("sysLogDao",SysLogDao.class);
	    Map<String,Object> map=dao.findById(9);
	    System.out.println(map);
	}
}
