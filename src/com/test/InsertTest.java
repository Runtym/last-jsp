package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.DBConnector;

public class InsertTest {

	private static String insertSql = "insert into test(name,age) values(?,?)";

	private static int insertTest(List<Map<String, Object>> dataList) {
		int cnt = 0;
		try (Connection con = DBConnector.getConnection(); 
				PreparedStatement ps = con.prepareStatement(insertSql);) {
			
			for (int i = 0; i < dataList.size(); i++) {
				Map<String, Object> user = dataList.get(i);
				ps.setObject(1, user.get("name"));
				ps.setObject(2, user.get("age"));
				ps.addBatch();
				if(i%10000==100) {
					ps.executeBatch();
					ps.clearBatch();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public static void main(String[] args) {
		List<Map<String, Object>> dataList = new ArrayList<>();
		long sTime = System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			Map<String, Object> hm = new HashMap<>();
			hm.put("name", "이름" + i);
			int age = (int) (Math.random() * 100) + 1;
			hm.put("age", age);
			dataList.add(hm);
		}
		insertTest(dataList);
		System.out.println("총 실행 시간 : " + (System.currentTimeMillis()-sTime));
	}
}
