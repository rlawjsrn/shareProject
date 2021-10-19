package co.yedam.petcafe;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/PetCafeListServlet")
public class PetCafeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PetCafeListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		PetCafeDAO dao = new PetCafeDAO();
		List<PetCafeOneVO> list = dao.getCafeList();

		Gson gson = new GsonBuilder().create(); // Gson 객체를 Gson 타입의 gson변수로 선언
		response.getWriter().println(gson.toJson(list)); // list를 json문자열으로 변환 후 response함

		System.out.println(list);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
