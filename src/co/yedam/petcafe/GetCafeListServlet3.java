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

@WebServlet("/GetCafeListServlet3")
public class GetCafeListServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GetCafeListServlet3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
			
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().create();
	
		PetCafeDAO dao = new PetCafeDAO();
		List<PetCafeOneVO> list = dao.getTopCafeOutdoor();
		
		out.println(gson.toJson(list));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
