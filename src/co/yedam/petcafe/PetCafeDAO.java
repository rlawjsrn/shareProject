package co.yedam.petcafe;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class PetCafeDAO extends DAO {
	
	public List<PetCafeVO> getCafeList(){
		connect();
		List<PetCafeVO> list = new ArrayList<>();
		String sql = "select * from cafe order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				PetCafeVO vo = new PetCafeVO();
				vo.setCafe_name(rs.getString("cafe_name"));
				vo.setCafe_add(rs.getString("cafe_add"));
				vo.setCafe_phone(rs.getString("cafe_phone"));
				vo.setCafe_time(rs.getString("cafe_time"));
				vo.setCafe_type(rs.getString("cafe_type"));
				vo.setCafe_image(rs.getString("cafe_image"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 파일 업로드 처리
	public PetCafeVO uploadCafe(String cafe_name, String cafe_address, String cafe_phone, String cafe_time, String cafe_type, String cafe_image) {
		connect();
		String sql = "insert into cafe values(?, ?, ?, ?, ?, ?, ?, 0)";
		try {
			int nextNum = -1;
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select nvl(max(num), 0) +1 from fileboard");
			if (rs.next()) {
				nextNum = rs.getInt(1);
			}
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,  nextNum);
			psmt.setString(2, cafe_name);
			psmt.setString(3, cafe_address);
			psmt.setString(4, cafe_phone);
			psmt.setString(5, cafe_time);
			psmt.setString(6, cafe_type);
			psmt.setString(7, cafe_image);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
			
			PetCafeVO vo = new PetCafeVO();
			vo.setCafe_name(rs.getString("cafe_name"));
			vo.setCafe_add(rs.getString("cafe_add"));
			vo.setCafe_phone(rs.getString("cafe_phone"));
			vo.setCafe_time(rs.getString("cafe_time"));
			vo.setCafe_type(rs.getString("cafe_type"));
			vo.setCafe_image(rs.getString("cafe_image"));
			return vo;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
			
		} finally {
			disconnect();
		}
	}
}
