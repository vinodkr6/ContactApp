package com.ibm.devops;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class ServiceServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String students = request.getParameter("students");
		JSONObject person = new JSONObject(students);
		String employeeId = person.getString("employeeId");
		String employeeName = person.getString("employeeName");
		String employeeEmail = person.getString("employeeEmail");
		String employeeAddress = person.getString("employeeAddress");
		String employeePhone = person.getString("employeePhone");
		EmployeeVO employeeVO = new EmployeeVO();

		employeeVO.setEmployeeId(employeeId);
		employeeVO.setEmployeeName(employeeName);
		employeeVO.setEmployeeEmail(employeeEmail);
		employeeVO.setEmployeeAddress(employeeAddress);
		employeeVO.setEmployeePhone(employeePhone);

		EmployeeDAO dao = new EmployeeDAO();
		int status = 0;
		String errorMsg= null;
		try {
			System.out.println(person);
			status = dao.addEmployee(employeeVO);
			System.out.println(status);
			

			
		} catch (Exception e) {
			errorMsg = e.getMessage();
			System.out.println(errorMsg);
			e.printStackTrace();
		}
		if (status > 0) {
			response.getWriter().write("SUCCESS");
		} else {
			response.getWriter().write(errorMsg);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
