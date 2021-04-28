package it.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmpIdAgeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setId(arg0.getInt("EmpId"));
		emp.setEta(arg0.getInt("Age"));
		return emp;
	}

}
