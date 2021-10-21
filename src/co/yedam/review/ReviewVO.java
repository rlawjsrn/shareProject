package co.yedam.review;

public class ReviewVO {
	
	private int rwNum;
	private int rwcafeNum;
	private String rwId;
	private double rwScore;
	private String rwComment;
	public int getRwNum() {
		return rwNum;
	}
	public void setRwNum(int rwNum) {
		this.rwNum = rwNum;
	}
	public int getRwcafeNum() {
		return rwcafeNum;
	}
	public void setRwcafeNum(int rwcafeNum) {
		this.rwcafeNum = rwcafeNum;
	}
	public String getRwId() {
		return rwId;
	}
	public void setRwId(String rwId) {
		this.rwId = rwId;
	}
	public double getRwScore() {
		return rwScore;
	}
	public void setRwScore(double rwScore) {
		this.rwScore = rwScore;
	}
	public String getRwComment() {
		return rwComment;
	}
	public void setRwComment(String rwComment) {
		this.rwComment = rwComment;
	}
	@Override
	public String toString() {
		return "ReviewVO [rwNum=" + rwNum + ", rwcafeNum=" + rwcafeNum + ", rwId=" + rwId + ", rwScore=" + rwScore
				+ ", rwComment=" + rwComment + "]";
	}
	
	
}
