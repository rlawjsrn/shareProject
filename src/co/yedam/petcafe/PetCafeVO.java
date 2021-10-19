package co.yedam.petcafe;

public class PetCafeVO {

	private int cafe_num;
	private String cafe_name;
	private String cafe_add;
	private String cafe_phone;
	private String cafe_time;
	private String cafe_image;
	private String cafe_type;
	private String cafe_score;
	
	public int getCafe_num() {
		return cafe_num;
	}
	public void setCafe_num(int cafe_num) {
		this.cafe_num = cafe_num;
	}
	public String getCafe_name() {
		return cafe_name;
	}
	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}
	public String getCafe_add() {
		return cafe_add;
	}
	public void setCafe_add(String cafe_add) {
		this.cafe_add = cafe_add;
	}
	public String getCafe_phone() {
		return cafe_phone;
	}
	public void setCafe_phone(String cafe_phone) {
		this.cafe_phone = cafe_phone;
	}
	public String getCafe_time() {
		return cafe_time;
	}
	public void setCafe_time(String cafe_time) {
		this.cafe_time = cafe_time;
	}
	public String getCafe_image() {
		return cafe_image;
	}
	public void setCafe_image(String cafe_image) {
		this.cafe_image = cafe_image;
	}
	public String getCafe_type() {
		return cafe_type;
	}
	public void setCafe_type(String cafe_type) {
		this.cafe_type = cafe_type;
	}
	public String getCafe_score() {
		return cafe_score;
	}
	public void setCafe_score(String cafe_score) {
		this.cafe_score = cafe_score;
	}
	@Override
	public String toString() {
		return "PetCafeVO [cafe_num=" + cafe_num + ", cafe_name=" + cafe_name + ", cafe_add=" + cafe_add
				+ ", cafe_phone=" + cafe_phone + ", cafe_time=" + cafe_time + ", cafe_image=" + cafe_image
				+ ", cafe_type=" + cafe_type + ", cafe_score=" + cafe_score + "]";
	}
	
}
