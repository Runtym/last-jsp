package com.test;

import static org.junit.Assert.assertNotEquals;

import java.sql.Connection;

import org.junit.Test;

import com.common.DBConnector;

public class DBConnectorTest {

	@Test
	public void correctInitDriverClassNameTest(){
		DBConnector.initDriver();
	}

	@Test
	public void openTest(){
		DBConnector.open();
	}

	@Test
	public void getConnectionTest() {
		Connection con = DBConnector.getConnection();
		assertNotEquals(null, con);
	}
}





