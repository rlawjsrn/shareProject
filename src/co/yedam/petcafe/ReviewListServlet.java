package co.yedam.petcafe;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.review.ReviewDAO;
import co.yedam.review.ReviewVO;


@WebServlet("/ReviewListServlet")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ReviewListServlet() {
        super();
      }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int cafeNum = Integer.parseInt(request.getParameter("cafeNum"));
		
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().create();
		
		ReviewDAO dao = new ReviewDAO();
		//List<ReviewVO> list = dao.getReviewList(cafeNum);
		
		System.out.println(list);
		System.out.println(cafeNum);
		out.println(gson.toJson(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
