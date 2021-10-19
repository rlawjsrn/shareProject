package co.yedam.petcafe;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/AddPetCafeServlet")
public class AddPetCafeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddPetCafeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String cafeName = request.getParameter("name");
		String cafeAddress = request.getParameter("add");
		String cafePhone = request.getParameter("phone");
		String cafeTime = request.getParameter("time");
		String cafeType = request.getParameter("type");
		String cafeImage = request.getParameter("image");
		System.out.println("앞단 정보:" + cafeName + cafeAddress + cafePhone + cafeTime + cafeType + cafeImage);
		
		PetCafeDAO dao = new PetCafeDAO();
		PetCafeOneVO vo = new PetCafeOneVO();
		
		vo.setCafeName(cafeName);
		vo.setCafeAdd(cafeAddress);
		vo.setCafePhone(cafePhone);
		vo.setCafeTime(cafeTime);
		vo.setCafeType(cafeType);
		vo.setCafeImage(cafeImage);
		
		String dbAdd = dao.checkAdd(vo);
		int r = -1;
		
		if (dbAdd == null || db)
			
		response.getWriter().println();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}