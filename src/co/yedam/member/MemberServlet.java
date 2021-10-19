package co.yedam.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberServlet() {
		super();

	}

	// 로그인 서블릿
	protected void doGet(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		// request에 담겨있는 값을 서블릿 변수에 담기.
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");
		System.out.println("앞단 정보:" + userId + userPw);

		// DAO호출
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO(); // DAO 의 메소드가 memberVO클래스를 인자값으로 받기 때문.

		// memberVO클래스에 앞단에서 가져온 값을 세팅함.
		vo.setUserId(userId);
		vo.setUserPw(userPw);

		// 앞쪽 vo: 메소드로부터 리턴타입 뒷쪽vo: 메소드의 인자값
		vo = dao.checkMember(vo); // =은 같다의 뜻이 아닌 오른쪽을 왼쪽에 '담는다'는 뜻

		// db에서 가져온 값을 저장.
		String dbId = vo.getUserId();
		String dbPw = vo.getUserPw();
		System.out.println("백단 정보: " + dbId + dbPw);

		//로그인 일치 검사
		int r = -1;
		if (userId == dbId && userPw == dbPw) { //로그인 성공
			r = 1;
			session.setAttribute("sessionId", dbId); //세션에 로그인 한 아이디 담기
		}else {//로그인 실패
			r = 0;
		}
		
		System.out.println(r);
		
		
		
		response.getWriter().println(r);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // doGet 메소드 실행

		doGet(request, response);
	}

}
