package co.yedam.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JoinServlet() {
		super();

	}

	// 회원가입 서블릿
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		// request에 담겨있는 값을 서블릿 변수에 담기.
		String userId = request.getParameter("id");
		String pswd = request.getParameter("pw");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		System.out.println("앞단 정보:" + userId + pswd + email + phone);

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setUserId(userId);
		vo.setUserPw(pswd);
		vo.setUserEmail(email);
		vo.setUserPhone(phone);

		// 아이디 중복이 아닌 경우
		String dbId = dao.checkId(vo);
		int r = -1;
		
		if (dbId == null || dbId.equals("")) {// dbId가 존재하지 않을 떄
			// 회원가입을 한다
			r = dao.insertMember(vo); //r=1
		} else { //이미 존재하는 아이디
			r = 0;
		}
		
		System.out.println(r);

		response.getWriter().println(r);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
