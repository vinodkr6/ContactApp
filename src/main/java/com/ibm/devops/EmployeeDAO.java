package com.ibm.devops;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	public int addEmployee(EmployeeVO employeeVO) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		int insertStatus = 0;
		try {
			String sql = "INSERT INTO DEVOPS_DB.TEAM_INFO(EMP_ID,EMP_NAME,EMP_EMAIL,EMP_ADDRESS,EMP_PHONE) VALUES (?,?,?,?,?)";
			con = DBUtility.getDBConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, employeeVO.getEmployeeId());
			ps.setString(2, employeeVO.getEmployeeName());
			ps.setString(3, employeeVO.getEmployeeEmail());
			ps.setString(4, employeeVO.getEmployeeAddress());
			ps.setString(5, employeeVO.getEmployeePhone());
			insertStatus = ps.executeUpdate();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw e;
		}finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
		
		return insertStatus;
	}
	
	
	public int deleteEmployee(String empId) throws Exception {
		;
		Connection con = null;
		PreparedStatement ps = null;
		int insertStatus = 0;
		try {
			String sql = "DELETE FROM DEVOPS_DB.TEAM_INFO WHERE EMP_ID = ?";
			con = DBUtility.getDBConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, empId.trim());
			insertStatus = ps.executeUpdate();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw e;
		}finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
		
		return insertStatus;
	}

	public List<EmployeeVO> getAllEmployees() throws Exception {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int insertStatus = 0;
		EmployeeVO vo = null;
		List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();
		try {
			String sql = "SELECT EMP_ID,EMP_NAME,EMP_EMAIL,EMP_ADDRESS,EMP_PHONE FROM DEVOPS_DB.TEAM_INFO";
			con = DBUtility.getDBConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				vo = new EmployeeVO();
				vo.setEmployeeId(rs.getString("EMP_ID"));
				vo.setEmployeeName(rs.getString("EMP_NAME"));
				vo.setEmployeeEmail(rs.getString("EMP_EMAIL"));
				vo.setEmployeeAddress(rs.getString("EMP_ADDRESS"));
				vo.setEmployeePhone(rs.getString("EMP_PHONE"));
				employeeList.add(vo);
			}
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw e;
		}finally {
			if(st != null) {
				st.close();
			}
			if(con != null) {
				con.close();
			}
		}
		
		return employeeList;
	}

}
