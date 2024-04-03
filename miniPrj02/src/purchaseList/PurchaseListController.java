package purchaseList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import phone.PhoneVo;
import util.Util;

public class PurchaseListController {

	public void sellPhone() throws Exception {
		int score = 100;
		int num1 = 0;
		int num2 = 0;
		String price = "";
		String grade = "";
		String inputPhoneName = "";
		System.out.println("기종을 선택해주세요.");
		System.out.println("1. 아이폰");
		System.out.println("2. 갤럭시");
		String inputNum1 = Util.SC.nextLine();

		if (inputNum1.equals("1")) {
			System.out.println("1. 기본 모델");
			System.out.println("2. 프로 모델");
			System.out.println("3. Xs");
			String inputNum2 = Util.SC.nextLine();
			if (inputNum2.equals("1")) {
				System.out.println("모델의 넘버를 입력해주세요.");
				String inputNumber1 = Util.SC.nextLine();
				inputPhoneName = "IPHONE ";
				inputPhoneName += inputNumber1;
			} else if (inputNum2.equals("2")) {
				System.out.println("모델의 넘버를 입력해주세요.");
				String inputNumber2 = Util.SC.nextLine();
				inputPhoneName = "IPHONE PRO ";
				inputPhoneName += inputNumber2;
			} else if (inputNum2.equals("3")) {
				inputPhoneName = "IPHONE XS";
			}
		} else if (inputNum1.equals("2")) {
			System.out.println("시리즈의 넘버를 입력해주세요.");
			String inputNumber3 = Util.SC.nextLine();
			inputPhoneName = "GALAXY S";
			inputPhoneName += inputNumber3;
		}

		System.out.println("배터리의 성능 수치를 입력해주세요.");
		String inputBatteryNum = Util.SC.nextLine();
		System.out.println("핸드폰 액정의 스크레치 개수를 입력해주세요.");
		String inputScratchNum = Util.SC.nextLine();

		System.out.println("등급 측정 중...");

		int batteryNum = Integer.parseInt(inputBatteryNum);
		int scratchNum = Integer.parseInt(inputScratchNum);

		if (batteryNum > 90 && batteryNum <= 100) {
			num1 = 0;
		} else if (batteryNum > 80 && batteryNum <= 90) {
			num1 = 10;
		} else if (batteryNum > 70 && batteryNum <= 80) {
			num1 = 15;
		} else if (batteryNum > 60 && batteryNum <= 70) {
			num1 = 20;
		}
		System.out.println("점수 차감 .. -" + num1);
		score -= num1;

		num2 = scratchNum * 5;
		System.out.println("점수 차감 .. -" + num2);
		score -= num2;

		if (score > 90 && score <= 100) {
			grade = "A";
		} else if (score > 80 && score <= 90) {
			grade = "B";
		} else if (score > 70 && score <= 80) {
			grade = "C";
		} else if (score > 60 && score <= 70) {
			grade = "D";
		}

		String phoneNumber = "";
		for (PhoneVo vo : Util.phoneList) {
			if (grade.equals(vo.getGrade())) {
				if (inputPhoneName.equals(vo.getModelName())) {
					phoneNumber = vo.getNo();
					price = vo.getGradePrice();
				}
			}
		}

		Connection conn = Util.getConn();
		String sql = "INSERT INTO PURCHASE_LIST(NO, PHONE_NUMBER, MEMBER_ID, BATTERY_NUM, SCRATCH_NUM, TOTAL_SCORE) VALUES(SEQ_PURCHASE_LIST_NO.NEXTVAL, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt = conn.prepareCall(sql);

		pstmt.setString(1, phoneNumber);
		pstmt.setString(2, "getId()");
		pstmt.setString(3, inputBatteryNum);
		pstmt.setString(4, inputScratchNum);
		pstmt.setInt(5, score);

		int result = pstmt.executeUpdate();
		if (result != 1) {
			System.out.println("중고폰 판매 실패!");
			return;
		}
		System.out.println("중고폰 판매 성공!");
		System.out.println(price + "원이 입금되었습니다.");

	}

	public void sellInfo() throws Exception {
		Connection conn = Util.getConn();
		String sql = "SELECT * FROM PURCHASE_LIST WHERE MEMBER_ID = ?";
		PreparedStatement pstmt = conn.prepareCall(sql);
		pstmt.setString(1, "getId()");

		ResultSet rs = pstmt.executeQuery();
		PurchaseListVo vo = null;
		ArrayList<PurchaseListVo> list = new ArrayList<PurchaseListVo>();
		while (rs.next()) {
			String no = rs.getString("NO");
			String phoneNumber = rs.getString("PHONE_NUMBER");
			String memberId = rs.getString("MEMBER_ID");
			String scratchNum = rs.getString("SCRATCH_NUM");
			String batteryNum = rs.getString("BATTERY_NUM");
			String totalScore = rs.getString("TOTAL_SCORE");
			String enrollDate = rs.getString("ENROLL_DATE");
			vo = new PurchaseListVo(no, phoneNumber, memberId, scratchNum, batteryNum, totalScore, enrollDate);
			list.add(vo);
		}
		if(vo == null) {
			System.out.println("판매 내역 조회 실패..");
			return;
		}
		System.out.println("중고폰 판매 내역 조회 성공!");
		for(PurchaseListVo pvo : list) {
			System.out.print(pvo.getNo());
			System.out.print(pvo.getPhoneNumber());
			System.out.print(pvo.getMemberId());
			System.out.print(pvo.getScratchNum());
			System.out.print(pvo.getBatteryNum());
			System.out.print(pvo.getTotalScore());
			System.out.print(pvo.getEnrollDate());
		}

	}

}
