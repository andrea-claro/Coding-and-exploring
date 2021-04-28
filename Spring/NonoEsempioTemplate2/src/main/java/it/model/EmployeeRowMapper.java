package it.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee>{



	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setNome(rs.getString("Name"));
		emp.setEta(rs.getInt("Age"));
		emp.setId(rs.getInt("EmpId"));
		return emp;
	}

	

}
