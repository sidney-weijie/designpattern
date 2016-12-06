package com.sidney.foundation.db;

import com.alibaba.fastjson.JSON;

import com.sidney.foundation.dto.Student;

public class TestDbConnection {

	public static void main(String[] args) {
		
		try {
			MyDataSource ds = new MyDataSource();
			

			
		MyJdbcFrame jdbc = new MyJdbcFrame(ds);
			
			String sql = "select * from `sidney`.`student` where id=?;";
			BeanHandler bsh = new BeanHandler(Student.class);
			
			Integer id = 1;
			Integer [] parameter = new Integer[]{id};
			Student  student = (Student)jdbc.query(sql, parameter, bsh);
			if(null != student){
				System.err.println(JSON.toJSONString(student));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
