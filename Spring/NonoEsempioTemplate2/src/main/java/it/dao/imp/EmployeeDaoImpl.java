package it.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import it.dao.EmployeeDao;
import it.model.EmpIdAgeMapper;
import it.model.Employee;
import it.model.EmployeeRowMapper;

//@Repository("pippo")
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int getRowCount(){
		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from employee", Integer.class);
		
		return rowCount;
	}
	
	@Override
	public Employee getEmployeeById(int empId) {
	
	// Per Mapper alternativo su due attributi
	//String query = "select empId,age from Employee where EmpId = ?";
		
	String query = "select * from Employee where EmpId = ?";
	// using RowMapper anonymous class, we can create a separate RowMapper

//	Employee employee = jdbcTemplate.queryForObject(query,new Object[] { empId }, new RowMapper<Employee>() {
//		@Override
//		public Employee mapRow(ResultSet rs,int rowNum) throws SQLException {
//			Employee employee = new Employee(rs.getInt("EmpId"), rs.getString("Name"), rs.getInt("Age"));
//		 return employee;
//	    } 
//	});
	
	//Mapper alternativo su due attributi
	//Employee employee = jdbcTemplate.queryForObject(query,new Object[] { empId }, new EmpIdAgeMapper());
	Employee employee = jdbcTemplate.queryForObject(query,new Object[] { empId }, new EmployeeRowMapper());
	return employee;
	}
	
	@Override
	public List<Employee> getListEmployee() {
		String query = "select * from Employee";
		return jdbcTemplate.query(query, new EmployeeRowMapper());
	}
	
	
	
	

}
