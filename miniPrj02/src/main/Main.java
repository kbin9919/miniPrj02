package main;

import phone.PhoneController;
import purchaseList.PurchaseListController;
import util.Util;

public class Main {
	
	public void printMenu() throws Exception {
		PhoneController phc = new PhoneController();
		PurchaseListController plc = new PurchaseListController();
		phc.phoneInfoLoad();
		boolean run = true;
		while(run) {
			System.out.println("1. 중고폰 판매");
			System.out.println("2. 판매한 중고폰 조회");
			System.out.println("3. 중고폰 시세 전체 조회");
			System.out.println("4. 중고폰 시세 상세 조회");
			System.out.println("5. 등급 산정표 조회");
			
			System.out.println("8. 돌아가기");
			System.out.println("9. 종료");
			
			String inputNum = Util.SC.nextLine();
			switch (inputNum) {
			case "1":
				plc.sellPhone();
				break;
			case "2":
				plc.sellInfo();
				break;
			case "3":
				phc.phoneInfo();
				break;
			case "4":
				phc.phoneDetailInfo();
				break;
			case "5":
				
				break;
			case "8":
				
				break;
			case "9":
				System.out.println("시스템 종료.");
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해주세요"); break;
			}
		}
		

	}
	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.printMenu();
		
		
	}
}
