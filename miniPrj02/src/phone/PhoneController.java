package phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.Util;

public class PhoneController {
	
	public void phoneInfoLoad() throws Exception {
		Connection conn = Util.getConn();
		String sql = "SELECT NO, MODEL_NAME, GRADE, GRADE_PRICE FROM PHONE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		PhoneVo vo = null;
		while (rs.next()) {
			String no = rs.getString("NO");
			String modelName = rs.getString("MODEL_NAME");
			String grade = rs.getString("GRADE");
			String gradePrice = rs.getString("GRADE_PRICE");
			vo = new PhoneVo(no, modelName, grade, gradePrice);
			Util.phoneList.add(vo);
		}
	}
	public void phoneInfo() throws Exception {
		if(Util.phoneList.get(0) == null) {
			System.out.println("중고폰 시세 조회 실패..");
			return;
		}
		System.out.println("중고폰 시세 조회 성공!");
		for(PhoneVo vo : Util.phoneList) {
			System.out.println("==============================================================");
			System.out.print("  |  ");
			System.out.print("No :");
			System.out.print(vo.getNo());
			System.out.print("  |  ");
			System.out.print("기종 :");
			System.out.print(vo.getModelName());
			System.out.print("  |  ");
			System.out.print("등급 :");
			System.out.print(vo.getGrade());
			System.out.print("  |  ");
			System.out.print("가격 :");
			System.out.print(vo.getGradePrice());
			System.out.println("  |  ");
		}
	}
	public void phoneDetailInfo() throws Exception {
		Connection conn = Util.getConn();
		String sql = "SELECT NO, MODEL_NAME, GRADE, GRADE_PRICE FROM PHONE WHERE MODEL_NAME LIKE ? AND GRADE = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		System.out.println("조회하실 기종을 입력하세요");
		String modelName = Util.SC.nextLine();
		if(modelName.contains("아이")) {
			modelName = "%IPHONE%";
		}else if(modelName.contains("프로")) {
			modelName = "%IPHONE PRO%";
		}else if(modelName.contains("갤럭시")) {
			modelName = "%GALAXY%";
		}else {
			System.out.println("잘못된 입력입니다. 한글로 입력해 주세요.");
			return;
		}
		System.out.println("조회하실 기종의 등급을 입력해주세요");
		String grade = Util.SC.nextLine();
		grade = grade.toUpperCase();
		pstmt.setString(1, modelName);
		pstmt.setString(2, grade);
		
		ResultSet rs = pstmt.executeQuery();
		PhoneVo vo = null;
		ArrayList<PhoneVo> list = new ArrayList<PhoneVo>();
		while (rs.next()) {
			String no = rs.getString("NO");
			String dbModelName = rs.getString("MODEL_NAME");
			String dbGrade = rs.getString("GRADE");
			String gradePrice = rs.getString("GRADE_PRICE");
			vo = new PhoneVo(no, dbModelName, dbGrade, gradePrice);
			list.add(vo);
		}
		if(vo == null) {
			System.out.println("중고폰 시세 조회 실패..");
			return;
		}
		System.out.println("중고폰 시세 조회 성공!");
		for(PhoneVo pvo : list) {
			System.out.println("-------------------------------");
			System.out.print("  |  ");
			System.out.print("No :");
			System.out.print(pvo.getNo());
			System.out.print("  |  ");
			System.out.print("기종 :");
			System.out.print(pvo.getModelName());
			System.out.print("  |  ");
			System.out.print("등급 :");
			System.out.print(pvo.getGrade());
			System.out.print("  |  ");
			System.out.print("가격 :");
			System.out.print(pvo.getGradePrice());
			System.out.print("  |  ");
			System.out.println("-------------------------------");
		}
	}
	
}
