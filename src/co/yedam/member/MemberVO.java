package co.yedam.member;

public class MemberVO {
	
	//변수
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone;
	private String userEmail;
	
	//setter getter메소드 변수에 값을 담거나 꺼내는 메소드
	public String getUserId() {
		return userId;
	}
	public void setUserId(String string) {
		this.userId = string;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userPhone="
				+ userPhone + ", userEmail=" + userEmail + "]";
	}
	
	
	
}
