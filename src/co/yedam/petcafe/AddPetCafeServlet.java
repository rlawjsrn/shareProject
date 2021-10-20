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
		
		ServletContext context = getServletContext();
		String saveDir = context.getRealPath("upload");
		int maxSize = 1024 * 1024 * 30;
		String encoding = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy()); //1. request, 2.saveDir, 3. maxFileSize, 4.encoding, 5. renamePolicy
		
		String cafeName = multi.getParameter("cafeName");
		String cafeAdd = multi.getParameter("cafeAdd");
		String cafePhone = multi.getParameter("cafePhone");
		String cafeTime = multi.getParameter("cafeTime");
		String cafeType = multi.getParameter("cafeType");
		String cafeImage = multi.getFilesystemName("cafeImage"); //파일이름
		
//		System.out.println("name:"+ cafeName);
//		System.out.println("add:" + cafeAdd);
//		System.out.println("phone:"+ cafePhone);
//		System.out.println("time:"+ cafeTime);
//		System.out.println("type:"+ cafeType);
//		System.out.println("image:"+ cafeImage);
		
		PetCafeDAO dao = new PetCafeDAO();
		PetCafeOneVO vo = dao.uploadCafe(cafeName, cafeAdd, cafePhone, cafeTime, cafeImage, cafeType); //db 순서대로
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().println(gson.toJson(vo));
		
		System.out.println(saveDir);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}