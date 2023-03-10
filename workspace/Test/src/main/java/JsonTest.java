

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

/**
 * Servlet implementation class JsonTest
 */
@WebServlet("/JsonTest")
public class JsonTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    request.setCharacterEncoding("utf8");
	    response.setContentType("application/json");
	    PrintWriter writer = response.getWriter();
	    response.setStatus(200);
	    //System.out.println(obj.get("message"));
	    People p1 = new People();
	    p1.setAge(10);
	    p1.setId(1);
	    p1.setName("andy");
	    People p2 = new People();
	    p2.setAge(12);
	    p2.setId(2);
	    p2.setName("becca");
	    List<People> list = new ArrayList<>();
	    list.add(p1);
	    list.add(p2);
	    Gson gson = new Gson();
	    writer.write(gson.toJson(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
