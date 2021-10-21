package co.yedam.review;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class ReviewDAO extends DAO {

	// 리뷰 목록 가져오기
	public List<ReviewVO> getReviewList(int rwcafeNum) {
		connect();
		String sql = "select * from review where rwcafe_num=?"; // 사용자가 클릭한 카페 번호의 리뷰 목록을 가져옴
		List<ReviewVO> list = new ArrayList<>(); // 하나의 리스트에 reviewVO클래스를 여러개 담기 떄문에 List클래스를 선언
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rwcafeNum);

			rs = psmt.executeQuery(); // 쿼리실행 -> 결과도출

			while (rs.next()) {
				ReviewVO vo = new ReviewVO();
				vo.setRwcafeNum(rs.getInt("rwcafe_num"));
				vo.setRwComment(rs.getString("rw_content"));
				vo.setRwId(rs.getString("rw_id"));
				vo.setRwNum(rs.getInt("rw_num"));
				vo.setRwScore(rs.getDouble("rw_score"));

				list.add(vo); // vo클래스를 list에 담음
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 리뷰 등록하기
	public int insertReview(ReviewVO reviewVO) {
		System.out.println(reviewVO);
		connect();
		String sql = "insert into review values(rw_num.nextval, ?, ?, ?, ?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, reviewVO.getRwcafeNum());
			psmt.setString(2, reviewVO.getRwId());
			psmt.setDouble(3, reviewVO.getRwScore());
			psmt.setString(4, reviewVO.getRwComment());
			r = psmt.executeUpdate();

			System.out.println(r + "건 등록");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			disconnect();
		}
		return r; // 리뷰가 등록되었다면 숫자 1(한 건)

	}

	// 리뷰 수정하기
	public int updateReview(ReviewVO reviewVO) {
		connect();
		String sql = "update review set rw_score=?, rw_comment=? where rw_num=?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setDouble(1, reviewVO.getRwScore());
			psmt.setString(2, reviewVO.getRwComment());
			psmt.setInt(3, reviewVO.getRwNum());
			r = psmt.executeUpdate();
			System.out.println(r + "건 수정");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return r; // 리뷰가 수정되었다면 숫자 1(한 건)
	}

	// 리뷰 삭제하기
	public int deleteReview(int rwNum) {
		connect();
		String sql = "delete from review where rw_num=?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rwNum);
			r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return r;
	}

}
