package com.ibm.devops;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

/**
 * Servlet implementation class AllDataServlet
 */
public class AllDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();
		EmployeeDAO dao = new EmployeeDAO();
		JSONArray jsonArray = null;
		String errorMesg = null;
		try {
			employeeList = dao.getAllEmployees();
            jsonArray = new JSONArray(employeeList);
            
		
		} catch (Exception e) {
			errorMesg = e.getMessage();
			e.printStackTrace();
		}
		if(errorMesg != null) {
			response.getWriter().write("ERROR:"+errorMesg);
		}else {
			response.getWriter().write(jsonArray.toString());
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
