package co.yedam.member;

import java.sql.SQLException;

import co.yedam.common.DAO;

//회원가입DAO
public class MemberDAO extends DAO {

	// 회원가입 정보입력
	public int insertMember(MemberVO memberVO) { // 인자값을 MemberVO클래스에서 받아옴. 메소드 안에선 MemberVO의 약어로 쓰겠다.
		connect();
		String sql = "insert into pet_member values(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberVO.getUserId());
			psmt.setString(2, memberVO.getUserPw());
			psmt.setString(3, memberVO.getUserEmail());
			psmt.setString(4, memberVO.getUserPhone());

			int r = psmt.executeUpdate(); // db결과로 나오는 숫자값(몇 건)
			System.out.println(r + "건 등록");

			return r;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			disconnect();
		}

	}

	// 회원가입시 아이디 중복체크
	public String checkId(MemberVO memberVO) { // db의 user_id값 도출. 사용자가 초기입력한 user_id와 다름!!
		connect();
		String sql = "select user_id from pet_member where user_id=?";
		String result = null;

		try {
			psmt = conn.prepareStatement(sql); // 작성한 구문을 쿼리로 인식
			psmt.setString(1, memberVO.getUserId());// 사용자가 입력한id를 가져옴

			rs = psmt.executeQuery(); // 쿼리실행 -> 결과값 도출

			if (rs.next()) {// 쿼리 결과값이 있다면
				result = rs.getString("user_id"); // 쿼리 결과값에서 user_id 컬럼의 값을 result에 담겠다 ("user_id"): 컬럼명
			}

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}

	}

	// 로그인 기능
	public MemberVO checkMember(MemberVO memberVO) { // 쿼리 결과값에서 id, pw가 담긴 memberVO클래스를 반환
		connect();
		String sql = "select user_id, user_pw from pet_member where user_id=? and user_pw=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberVO.getUserId()); // 사용자가 입력한 id값을 가져오겠다
			psmt.setString(2, memberVO.getUserPw()); // 사용자가 입력한 pw값을 가져오겠다

			rs = psmt.executeQuery(); // 쿼리실행 -> 결과값을 rs에 담겠다

			if (rs.next()) {
				memberVO.setUserId(rs.getString("user_id"));
				memberVO.setUserPw(rs.getString("user_pw"));
				return memberVO;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
		return null;
	}
}
