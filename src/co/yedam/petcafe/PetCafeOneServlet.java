package co.yedam.petcafe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		
		vo = dao.cafeOne(cafeNum); //dao에서 가져온 cafeOne의 cafeNum의 값을 vo에 담음
		
		String Name = vo.getCafeName(); //vo에서 가져온 cafeName을 Name변수에 담음
	
		System.out.println(Name); //Name출력
		
		Gson gson = new GsonBuilder().create(); //Gson 객체를 Gson 타입의 gson변수로 선언
		response.getWriter().println(gson.toJson(vo)); //vo 클래스를 json문자열으로 변환 후 response함
		
		System.out.println(vo);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
