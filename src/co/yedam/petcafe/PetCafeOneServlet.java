package co.yedam.petcafe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PetCafeOneServlet")
public class PetCafeOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PetCafeOneServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int cafeNum = Integer.parseInt(request.getParameter("cafeNum"));
		System.out.println(cafeNum);
		
		PetCafeOneDAO dao = new PetCafeOneDAO();
		PetCafeOneVO vo = new PetCafeOneVO(); 
		
		vo = dao.cafeOne(cafeNum); 
		
		System.out.println(vo.getCafeName());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
