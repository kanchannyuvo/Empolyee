package com.example.program.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.program.model.Division;
import com.example.program.model.Employee;
import com.example.program.model.IDivisionCount;

public interface DivisionRepository extends JpaRepository<Division, Integer> {

	Optional<Division> findByDivisionName(String divisionName);

	Optional<Division> findByDivisionNameContainingIgnoreCase(String divisionName);

	@Query(value = "select count(emp.divisionId) as total,emp.divisionId as divisionId from Employee As emp where emp.manager!=0 and emp.manager.manager!=0 GROUP BY emp.divisionId")
	List<IDivisionCount> getTotalCountBasedDivision();

	

}
