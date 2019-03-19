package com.ibm.devops;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class DeleteEmployee
 */
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empid = request.getParameter("id");
		System.out.println(empid);
		JSONObject obj = new JSONObject(empid);
		String employeeId = obj.getString("employeeId");
		System.out.println(employeeId.substring(2));
		EmployeeDAO dao = new EmployeeDAO();
		int status = 0;
		String errorMsg= null;
		try {
			status = dao.deleteEmployee(employeeId.substring(1));
			System.out.println(status);
		
			
		} catch (Exception e) {
			errorMsg = e.getMessage();
			System.out.println("ERRRRRR:   "+errorMsg);
			e.printStackTrace();
		}
		
		if (status > 0) {
			response.getWriter().write("SUCCESS");
		} else {
			response.getWriter().write(errorMsg);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
