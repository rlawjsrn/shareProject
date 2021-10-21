package co.yedam.petcafe;

public class PetCafeOneVO {

	private int cafeNum;
	private String cafeName;
	private String cafeAdd;
	private String cafePhone;
	private String cafeTime;
	private String cafeImage;
	private String cafeType;
	private double cafeScore;

	public int getCafeNum() {
		return cafeNum;
	}

	public void setCafeNum(int cafeNum) {
		this.cafeNum = cafeNum;
	}

	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public String getCafeAdd() {
		return cafeAdd;
	}

	public void setCafeAdd(String cafeAdd) {
		this.cafeAdd = cafeAdd;
	}

	public String getCafePhone() {
		return cafePhone;
	}

	public void setCafePhone(String cafePhone) {
		this.cafePhone = cafePhone;
	}

	public String getCafeTime() {
		return cafeTime;
	}

	public void setCafeTime(String cafeTime) {
		this.cafeTime = cafeTime;
	}

	public String getCafeImage() {
		return cafeImage;
	}

	public void setCafeImage(String cafeImage) {
		this.cafeImage = cafeImage;
	}

	public String getCafeType() {
		return cafeType;
	}

	public void setCafeType(String cafeType) {
		this.cafeType = cafeType;
	}

	public double getCafeScore() {
		return cafeScore;
	}

	public void setCafeScore(double cafeScore) {
		this.cafeScore = cafeScore;
	}

	@Override
	public String toString() {
		return "PetCafeOneVO [cafeNum=" + cafeNum + ", cafeName=" + cafeName + ", cafeAdd=" + cafeAdd + ", cafePhone="
				+ cafePhone + ", cafeTime=" + cafeTime + ", cafeImage=" + cafeImage + ", cafeType=" + cafeType
				+ ", cafeScore=" + cafeScore + "]";
	}

}
