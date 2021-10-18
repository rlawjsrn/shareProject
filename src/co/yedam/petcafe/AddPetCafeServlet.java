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
		
		String cafe_name = multi.getParameter("cafe_name");
		String cafe_address = multi.getParameter("cafe_address");
		String cafe_phone = multi.getParameter("cafe_phone");
		String cafe_time = multi.getParameter("cafe_time");
		String cafe_type = multi.getParameter("cafe_type");
		String cafe_image = multi.getFilesystemName("cafe_image");
		
		PetCafeDAO dao = new PetCafeDAO();
		PetCafeVO vo = dao.uploadCafe(cafe_name, cafe_address, cafe_phone, cafe_time, cafe_type, cafe_image);
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().println(gson.toJson(vo));
		
		System.out.println(saveDir);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}