package co.yedam.review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReviewServlet() {
		super();
	}
//MemberServlet참고
	
	// 리뷰 서블릿
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//request에 담겨있는 값(사용자가 입력한 값)을 서블릿 변수에 담기
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		double score = Double.parseDouble(request.getParameter("score"));
		int cafeNum = Integer.parseInt(request.getParameter("cafeNum"));
		
		//DAO호출
		ReviewDAO dao = new ReviewDAO();
		ReviewVO vo = new ReviewVO();
		
		//ReviewVO클래스에 앞단에서 가져온 값 세팅
		vo.setRwId(writer);
		vo.setRwComment(content);
		vo.setRwScore(score);
		vo.setRwcafeNum(cafeNum);
		
		int r = dao.insertReview(vo);
		PrintWriter out = response.getWriter();
		if( r == -1 ) {
			out.println("{\"Code\":\"fail\"}");
		}else {
			out.println("{\"Code\":\"success\"}");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
