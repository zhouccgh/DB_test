package com.test;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestDataSource extends TestBase{

	@Test
	public void testDataSource()throws Exception{
		DataSource ds=
		ctx.getBean("dataSource",DataSource.class);
		System.out.println(ds.getConnection());
		ComboPooledDataSource cps=
		ctx.getBean("c3p0",ComboPooledDataSource.class);
		System.out.println(cps.getConnection());
	
	}
}
