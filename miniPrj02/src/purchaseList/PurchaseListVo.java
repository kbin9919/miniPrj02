package purchaseList;

public class PurchaseListVo {
	private String no;
	private String phoneNumber;
	private String memberId;
	private String scratchNum;
	private String batteryNum;
	private String totalScore;
	private String enrollDate;

	public PurchaseListVo() {
		super();
	}

	public PurchaseListVo(String no, String phoneNumber, String memberId, String scratchNum, String batteryNum,
			String totalScore, String enrollDate) {
		super();
		this.no = no;
		this.phoneNumber = phoneNumber;
		this.memberId = memberId;
		this.scratchNum = scratchNum;
		this.batteryNum = batteryNum;
		this.totalScore = totalScore;
		this.enrollDate = enrollDate;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getScratchNum() {
		return scratchNum;
	}

	public void setScratchNum(String scratchNum) {
		this.scratchNum = scratchNum;
	}

	public String getBatteryNum() {
		return batteryNum;
	}

	public void setBatteryNum(String batteryNum) {
		this.batteryNum = batteryNum;
	}

	public String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "PurchaseListVo [no=" + no + ", phoneNumber=" + phoneNumber + ", memberId=" + memberId + ", scratchNum="
				+ scratchNum + ", batteryNum=" + batteryNum + ", totalScore=" + totalScore + ", enrollDate="
				+ enrollDate + "]";
	}

}
