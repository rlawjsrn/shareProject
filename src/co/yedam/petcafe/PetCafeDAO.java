package co.yedam.petcafe;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class PetCafeDAO extends DAO {
	
	//TOP 카페 조회
	public List<PetCafeOneVO> getTopCafeList() {
		connect();
		List<PetCafeOneVO> list = new ArrayList<>();
		String sql = "select * from cafe order by 8 desc;";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PetCafeOneVO vo = new PetCafeOneVO();
				vo.setCafeNum(rs.getInt("cafe_num"));
				vo.setCafeName(rs.getString("cafe_name"));
				vo.setCafeAdd(rs.getString("cafe_add"));
				vo.setCafePhone(rs.getString("cafe_phone"));
				vo.setCafeTime(rs.getString("cafe_time"));
				vo.setCafeImage(rs.getString("cafe_image"));
				vo.setCafeType(rs.getString("cafe_type"));
				vo.setCafeScore(rs.getDouble("cafe_score")); // score 타입 int ->double 변경 필요
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//카페 전체조회
	public List<PetCafeOneVO> getCafeList(){
		connect();
		List<PetCafeOneVO> list = new ArrayList<>();
		String sql = "select * from cafe order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				PetCafeOneVO vo = new PetCafeOneVO();
				vo.setCafeNum(rs.getInt("cafe_num"));
				vo.setCafeName(rs.getString("cafe_name"));
				vo.setCafeAdd(rs.getString("cafe_add"));
				vo.setCafePhone(rs.getString("cafe_phone"));
				vo.setCafeTime(rs.getString("cafe_time"));
				vo.setCafeImage(rs.getString("cafe_image"));
				vo.setCafeType(rs.getString("cafe_type"));
				vo.setCafeScore(rs.getDouble("cafe_score"));
				list.add(vo);
				System.out.println("vo:"+vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 카페등록 -> db에 저장
	public PetCafeOneVO uploadCafe(String cafeName, String cafeAdd, String cafePhone, String cafeTime, String cafeImage, String cafeType) {
		connect();
		System.out.println(cafeImage);
		String sql = "insert into cafe values(?, ?, ?, ?, ?, ?, ?, 0)";
		try {
			int nextNum = -1;
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select nvl(max(cafe_num), 0) +1 from cafe");
			if (rs.next()) {
				nextNum = rs.getInt(1);
			}
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,  nextNum);
			psmt.setString(2, cafeName);
			psmt.setString(3, cafeAdd);
			psmt.setString(4, cafePhone);
			psmt.setString(5, cafeTime);
			psmt.setString(6, cafeImage);
			psmt.setString(7, cafeType);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
			
			PetCafeOneVO vo = new PetCafeOneVO();
			vo.setCafeNum(nextNum);
			vo.setCafeName(cafeName);
			vo.setCafeAdd(cafeAdd);
			vo.setCafePhone(cafePhone);
			vo.setCafeTime(cafeTime);
			vo.setCafeImage(cafeImage);
			vo.setCafeType(cafeType);
			vo.setCafeScore(0);
			return vo;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
			
		} finally {
			disconnect();
		}
	}
	
	// 회원가입시 주소 중복체크
		public String checkCafeAdd(PetCafeOneVO PetCafeOneVO) { // db의 cafe_add 값, 사용자가 입력한 cafe_add와 다름
			connect();
			String sql = "select cafe_add from cafe where cafe_add=?";
			String result = null;

			try {
				psmt = conn.prepareStatement(sql); 
				psmt.setString(1, PetCafeOneVO.getCafeAdd());

				rs = psmt.executeQuery(); 

				if (rs.next()) {
					result = rs.getString("cafe_add"); // 쿼리 결과값에서 cafe_add 컬럼의 값
				}

				return result;

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				disconnect();
			}

		}
}
