package com.example.program.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.program.dto.EmpolyeeDTO;
import com.example.program.dto.EmpolyeeResponseDTO;
import com.example.program.exception.DivisionNotFoundException;
import com.example.program.exception.EmployeeNotFoundException;
import com.example.program.model.Division;
import com.example.program.model.Employee;
import com.example.program.model.EmployeeCount;
import com.example.program.model.IEmployeeCount;
import com.example.program.repository.DivisionRepository;
import com.example.program.repository.EmployeeRepository;

@Service
public class EmployeeService {


	@Autowired
	EmployeeRepository employeeRepository;


	@Autowired
	DivisionRepository divisionRepository;

	public EmpolyeeResponseDTO createNewEmployee(EmpolyeeDTO empDto) throws Exception {
		// TODO Auto-generated method stub

		Employee employee = new Employee();

		BeanUtils.copyProperties(empDto, employee);


		Optional<Division> divisionOptional = divisionRepository.findById(empDto.getDivisionId());


		if(!divisionOptional.isPresent())
		{
			throw new DivisionNotFoundException(empDto.getDivisionId());
		}

		employee.setDivision_id(divisionOptional.get());

		Optional<Employee> employeeOptional = employeeRepository.findByEmployeeNameContainingIgnoreCase(empDto.getManagerName());


		if(!employeeOptional.isPresent())
		{
			throw new EmployeeNotFoundException(empDto.getManagerName());
		}

		employee.setManager(employeeOptional.get());

		Employee personInDB = employeeRepository.save(employee);


		EmpolyeeResponseDTO empolyeeResponseDTO = new EmpolyeeResponseDTO();


		BeanUtils.copyProperties(empDto, empolyeeResponseDTO);

		empolyeeResponseDTO.setEmployeeId(personInDB.getEmployeeId());
		//empolyeeResponseDTO.setMessage("SuccessFul");


		return empolyeeResponseDTO;
	}

	public List<EmpolyeeResponseDTO> getEmployeeListBasedManage(String managerName) {
		// TODO Auto-generated method stub


		//List<Employee> managerList = employeeRepository.findByEmployeeNameLikeAndManager(managerName,"0");


		List<Employee> managerList = employeeRepository.findByEmployeeNameLike(managerName+"%");

		List<EmpolyeeResponseDTO> employeeList = new  ArrayList<EmpolyeeResponseDTO>();

		try
		{
			if(managerList!=null && managerList.size()>0)
			{
				managerList.forEach(manager -> {

					if(manager.getManager().getEmployeeId()!=0)
					{

						List<Employee> empList = employeeRepository.findByManager(manager);

						List<EmpolyeeResponseDTO> empList2 = new ArrayList<EmpolyeeResponseDTO>();

						if(empList!=null && empList.size()>0)
						{
							empList.forEach(emp ->{
								EmpolyeeResponseDTO empolyeeResponseDTO = new EmpolyeeResponseDTO();

								BeanUtils.copyProperties(emp, empolyeeResponseDTO);

								empolyeeResponseDTO.setDivisionId(emp.getDivision_id().getDivision_id());
								empolyeeResponseDTO.setManagerName(emp.getManager().getEmployeeName()); 

								empList2.add(empolyeeResponseDTO);
							});
						}

						employeeList.addAll(empList2);
					}

				});
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}


		System.out.println(employeeList);

		return employeeList;
	}

	public List<EmployeeCount> getTotalCountBasedManager() {

		List<IEmployeeCount> managerList = employeeRepository.getTotalCountBasedManager();


		List<EmployeeCount> empList = new ArrayList<EmployeeCount>();

		managerList.parallelStream().filter(emp -> emp.getManager().getManager().getEmployeeId()!=0).forEach(IEmployeeCount ->{

				EmployeeCount emp = new EmployeeCount(IEmployeeCount.getManager().getEmployeeName(),IEmployeeCount.getTotal()); 
				empList.add(emp); 

		});

		// TODO Auto-generated method stub
		return empList;
	}

}
