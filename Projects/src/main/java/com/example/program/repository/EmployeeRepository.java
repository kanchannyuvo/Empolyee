package com.example.program.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.program.model.Division;
import com.example.program.model.Employee;
import com.example.program.model.IEmployeeCount;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


	Optional<Employee> findByEmployeeNameContainingIgnoreCase(String lowerCase);


	List<Employee> findByManager(Employee manager);

	List<Employee> findByEmployeeNameLikeAndManager(String managerName, String string);


	List<Employee> findByEmployeeNameLike(String managerName);


	List<Employee> findByDivisionId(Division division);

	@Query(value = "select count(emp.manager) as total,emp.manager as manager from Employee As emp where emp.manager!=0 GROUP BY emp.manager")
	List<IEmployeeCount> getTotalCountBasedManager();


}
