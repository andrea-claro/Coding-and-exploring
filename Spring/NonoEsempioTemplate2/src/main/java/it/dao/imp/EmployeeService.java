package it.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.dao.EmployeeDao;

@Service
public class EmployeeService {
	
	@Autowired
	@Qualifier("employeeNameDaoImpl")
	private EmployeeDao dao;
	
	
	public int numRighe() {
		
		return dao.getRowCount();
	}

}
