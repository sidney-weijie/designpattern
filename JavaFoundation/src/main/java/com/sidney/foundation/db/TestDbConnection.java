package com.sidney.foundation.db;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.sidney.foundation.dto.Student;

public class TestDbConnection {

	public static void main(String[] args) {
		
		//testSingle();
		testMultiPle();
	}
	
	public static void testMultiPle(){
		try {
			MyDataSource ds = new MyDataSource();
			

			
		MyJdbcFrame jdbc = new MyJdbcFrame(ds);
			
			//String sql = "select * from `sidney`.`student` where id=?;";
			
			String sql = "select * from `sidney`.`student` ;";
			BeanHandler bsh = new BeanHandler(Student.class);
			
			Integer id = 1;
			Integer [] parameter = new Integer[]{};
			List<Student>list   = jdbc.queryBatch(sql, parameter, bsh);
			
			System.out.println(JSON.toJSONString(list));
			

				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void testSingle(){
		try {
			MyDataSource ds = new MyDataSource();
			

			
		MyJdbcFrame jdbc = new MyJdbcFrame(ds);
			
			String sql = "select * from `sidney`.`student` where id=?;";
			
			//String sql = "select * from `sidney`.`student` ;";
			BeanHandler bsh = new BeanHandler(Student.class);
			
			Integer id = 1;
			Integer [] parameter = new Integer[]{id};
			Student sti   = (Student)jdbc.query(sql, parameter, bsh);
			
			System.out.println(JSON.toJSONString(sti));
			

				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
