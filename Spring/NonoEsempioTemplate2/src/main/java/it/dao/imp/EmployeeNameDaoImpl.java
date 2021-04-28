package it.dao.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import it.dao.EmployeeDao;
import it.model.EmpIdAgeMapper;
import it.model.Employee;
import it.model.EmployeeRowMapper;

@Repository
public class EmployeeNameDaoImpl implements EmployeeDao {
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Override
	public int getRowCount() {
		return 5;
	}
	

	@Override
	public Employee getEmployeeById(int paramEmpId) {
		
		String query = "select * from Employee where EmpId = :empId and Age= :eta";
		//1	
		String query2 = "select * from Employee where EmpId = :empId";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("empId", Integer.valueOf(paramEmpId));
		//2
		MapSqlParameterSource mapParam = new MapSqlParameterSource();
		mapParam.addValue("empId", Integer.valueOf(paramEmpId));
		//mapParam.addValue("eta", 29);
		//Oppure un duovo oggetto con addValue su pi� parametri....
		//((MapSqlParameterSource)namedParameters).addValue("eta", Integer.valueOf(29));
		//MapSqlParameterSource mappaParametri = new MapSqlParameterSource();
		//mappaParametri.addValue(paramName, value);
		
		//3
		return (Employee) namedJdbcTemplate.queryForObject(query2,mapParam, new EmpIdAgeMapper());
	}


	@Override
	public List<Employee> getListEmployee() {
		
		String query = "select * from Employee";
		return namedJdbcTemplate.query(query, new EmployeeRowMapper());
	}

}
