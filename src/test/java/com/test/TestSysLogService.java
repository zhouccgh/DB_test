package com.test;

import java.lang.reflect.Field;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.db.common.vo.PageObject;
import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;
import com.db.sys.service.impl.SysLogServiceImpl;

public class TestSysLogService extends TestBase {

	@Test
	public void testFindPageObjects(){
		SysLogService logService=
		ctx.getBean("sysLogServiceImpl",SysLogService.class);
		PageObject<SysLog> po=
				logService.findPageObjects(
				"",
				1);
		System.out.println(po.getRowCount());
	}
	@Test
	public void testFindPageObjects02()throws Exception{
		SysLogService logService=
		new SysLogServiceImpl();
		SysLogDao sysLogDao=
		ctx.getBean("sysLogDao",SysLogDao.class);
		Class<?> cls=logService.getClass();
		Field f=
		cls.getDeclaredField("sysLogDao");
		f.setAccessible(true);
		boolean flag=f.isAnnotationPresent(Autowired.class);
		if(flag){
			f.set(logService, sysLogDao);
		}
		
		PageObject<SysLog> po=
				logService.findPageObjects(
						"",
						1);
		System.out.println(po.getRowCount());
	}
}
