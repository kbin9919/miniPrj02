package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

import phone.PhoneVo;

public class Util {
	public static final Scanner SC = new Scanner(System.in);
	public static ArrayList<PhoneVo> phoneList = new ArrayList<>();
	public static final Connection getConn() throws Exception {
	
		Connection conn = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KB03";
		String pwd = "1234";
		conn = DriverManager.getConnection(url, id, pwd);

		return conn;
	}
}
