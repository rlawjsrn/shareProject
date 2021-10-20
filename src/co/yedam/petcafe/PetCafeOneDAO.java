package co.yedam.petcafe;

import java.sql.SQLException;

import co.yedam.common.DAO;

public class PetCafeOneDAO extends DAO {

	// 카페 상세조회(프라이머리키인 cafe_num으로 조회)
	public PetCafeOneVO cafeOne(int cafeNum) { // (인자값 = 매개변수 = parameter 라고 부름) -> 외부로부터 받아오는 임의의 값
		connect();
		String sql = "select* from cafe where cafe_num=? "; // 인자값(사용자가 클릭한 cafe_num)으로 한 건 조회
		PetCafeOneVO petVO = new PetCafeOneVO(); // 클래스 선언 방식(new 연산자로 클래스메소드()를 초기화한다)

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cafeNum); // cafeNum은 외부로부터 받아온 인자값이다.

			rs = psmt.executeQuery(); // 쿼리실행 -> 결과값 도출

			if (rs.next()) {// 쿼리 결과값이 있다면
				petVO.setCafeNum(rs.getInt("cafe_num")); // get("컬럼명")은 컬럼명이 아닌 '컬럼의 값'을 가져온다.
				petVO.setCafeName(rs.getString("cafe_name"));
				petVO.setCafeAdd(rs.getString("cafe_add"));
				petVO.setCafePhone(rs.getString("cafe_phone"));
				petVO.setCafeTime(rs.getString("cafe_time"));
				petVO.setCafeImage(rs.getString("cafe_image"));
				petVO.setCafeType(rs.getString("cafe_type"));
				petVO.setCafeScore(rs.getInt("cafe_score"));
				
			}
			return petVO;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();

		}
	}

}