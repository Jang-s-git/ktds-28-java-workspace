package com.ktdsuniversity.edu.tmdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		
		// Java -> Oracle 연결하기 위한 URL
		String url = "jdbc:oracle:thin:@//localhost:1521/XE";
		// Oracle에 접속하기 위한 인증 정보
		String schemaName = "TMDB";
		String password = "TMDB";
		
		// Oracle로 접속
		try {
			
			Connection dbConnection = DriverManager.getConnection(url, schemaName, password);
			// 연결할 스키마 이름을 출력
			System.out.println(dbConnection.getSchema());
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
