package com.example.program.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.program.dto.DivisionDTO;
import com.example.program.dto.DivisionResponseDTO;
import com.example.program.dto.EmpolyeeResponseDTO;
import com.example.program.exception.EmployeeNotFoundException;
import com.example.program.model.Division;
import com.example.program.model.DivisionCount;
import com.example.program.model.Employee;
import com.example.program.model.IDivisionCount;
import com.example.program.repository.DivisionRepository;
import com.example.program.repository.EmployeeRepository;


@Service
public class DivisionService {


	@Autowired
	DivisionRepository divisionRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public  DivisionResponseDTO createNewDivision(DivisionDTO divisionDto) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub

		Division division = new Division();

		division.setBusiness(divisionDto.getBusiness());

		division.setDivisionName(divisionDto.getDivisionName());

		Optional<Division> divisionOptional = divisionRepository.findByDivisionNameContainingIgnoreCase(divisionDto.getDivisionName());

		DivisionResponseDTO responseDTO = new DivisionResponseDTO();

		if(!divisionOptional.isPresent())
		{

			Optional<Employee> employeeOptional = employeeRepository.findByEmployeeNameContainingIgnoreCase(divisionDto.getHeadName());

			Employee  employee = new Employee();

			if(!employeeOptional.isPresent())
			{


				employee.setEmployeeName(divisionDto.getHeadName());

				Optional<Employee> ceo = employeeRepository.findById(0);


				employee.setManager(ceo.get());

				employee = employeeRepository.save(employee);

				division.setEmployee(employee);	
			}
			else
			{
				division.setEmployee(employeeOptional.get());	
			}

			Division divisionDB = divisionRepository.save(division);



			if(!employeeOptional.isPresent())
			{
				employee.setDivision_id(divisionDB);

				System.out.println(employee.getEmployeeId());
				employeeRepository.save(employee);
			}



			responseDTO.setBusiness(divisionDto.getBusiness());
			responseDTO.setDivisionName(divisionDto.getDivisionName());
			responseDTO.setDivisionId(divisionDB.getDivision_id());
			responseDTO.setMessage("Successfull");
			responseDTO.setHeadName(divisionDB.getEmployee().getEmployeeName());

			return responseDTO; 

		}
		else
		{
			responseDTO.setBusiness(divisionOptional.get().getBusiness());
			responseDTO.setDivisionName(divisionOptional.get().getDivisionName());
			responseDTO.setDivisionId(divisionOptional.get().getDivision_id());
			responseDTO.setMessage("Record Already Present");
			responseDTO.setHeadName(divisionOptional.get().getEmployee().getEmployeeName());
			return responseDTO; 
		}
	}

	public List<EmpolyeeResponseDTO> getEmployeeByDivision(String divisionName) {
		// TODO Auto-generated method stub

		Optional<Division> divisionOptional = divisionRepository.findByDivisionNameContainingIgnoreCase(divisionName);

		List<EmpolyeeResponseDTO> divisionRespList = new  ArrayList<EmpolyeeResponseDTO>();

		if(divisionOptional.isPresent())
		{
			List<Employee> employeeList = employeeRepository.findByDivisionId(divisionOptional.get());

			if(employeeList!=null && employeeList.size()>0)
			{
				employeeList.parallelStream().filter(emp -> emp.getManager().getEmployeeId()!=0 && emp.getManager().getManager().getEmployeeId()!=0).forEach(emp ->{
				
						EmpolyeeResponseDTO empolyeeResponseDTO = new EmpolyeeResponseDTO();

						BeanUtils.copyProperties(emp, empolyeeResponseDTO);

						empolyeeResponseDTO.setDivisionId(emp.getDivision_id().getDivision_id());
						empolyeeResponseDTO.setManagerName(emp.getManager().getEmployeeName()); 

						divisionRespList.add(empolyeeResponseDTO);

				});
			}

		}


		return divisionRespList;
	}


	public Set<EmpolyeeResponseDTO> getManagerByDivision(String divisionName) {
		// TODO Auto-generated method stub
		Optional<Division> divisionOptional = divisionRepository.findByDivisionNameContainingIgnoreCase(divisionName);

		Set<EmpolyeeResponseDTO> divisionRespList = new  HashSet<EmpolyeeResponseDTO>();

		if(divisionOptional.isPresent())
		{
			List<Employee> employeeList = employeeRepository.findByDivisionId(divisionOptional.get());

			if(employeeList!=null && employeeList.size()>0)
			{
				employeeList.parallelStream().filter(emp -> emp.getManager().getManager().getEmployeeId()==0 && emp.getManager().getEmployeeId()!=0).forEach(emp ->{

						EmpolyeeResponseDTO empolyeeResponseDTO = new EmpolyeeResponseDTO();

						BeanUtils.copyProperties(emp, empolyeeResponseDTO);

						empolyeeResponseDTO.setDivisionId(emp.getDivision_id().getDivision_id());
						empolyeeResponseDTO.setManagerName(emp.getManager().getEmployeeName()); 

						divisionRespList.add(empolyeeResponseDTO);

				});
			}

		}


		return divisionRespList;
	}

	public List<DivisionCount> getTotalCountBasedDivision() {
		// TODO Auto-generated method stub
		List<IDivisionCount> managerList = divisionRepository.getTotalCountBasedDivision();


		List<DivisionCount> empList = new ArrayList<DivisionCount>();

		managerList.forEach(IDivisionCount ->{


			DivisionCount count = new DivisionCount(IDivisionCount.getDivisionId().getDivision_id(),IDivisionCount.getTotal()); 
			empList.add(count); 


		});

		// TODO Auto-generated method stub
		return empList;
	}


}
