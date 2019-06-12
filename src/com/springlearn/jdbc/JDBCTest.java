package com.springlearn.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class JDBCTest {
	
//		private ApplicationContext ctx= null;
//		private JdbcTemplate jdbcTemplate;
//		{
//			new ClassPathXmlApplicationContext("jdbc-context.xml");
//			jdbcTemplate =(JdbcTemplate) ctx.getBean("jdbcTemplate");
//		}
//		@Test
//		public void testDataSource() throws SQLException{
//			DataSource dataSource = (DataSource) ctx.getBean("dataSource");
//			System.out.println(dataSource.getConnection());
//		}
	
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("jdbc-context.xml");
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
		
		String sql="UPDATE sun_order SET V_num = ? WHERE V_id = ?";
		jdbcTemplate.update(sql,12,2);
		
//		String sql="INSERT INTO sun_order(V_id,V_time,V_num) VALUES(?,?,?)";
//		List<Object[]> batchArgs=new ArrayList<>();
//		batchArgs.add(new Object[] {3,"2019-06-13 18:00",8});
//		batchArgs.add(new Object[] {4,"2019-06-13 19:00",6});
//		batchArgs.add(new Object[] {5,"2019-06-13 17:00",5});
//		batchArgs.add(new Object[] {6,"2019-06-13 12:00",4});
//		jdbcTemplate.batchUpdate(sql, batchArgs);
		System.out.println(dataSource.getConnection());
		
	}
}


