package com.example.program.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.program.dto.EmpolyeeDTO;
import com.example.program.dto.EmpolyeeResponseDTO;
import com.example.program.model.EmployeeCount;
import com.example.program.model.IEmployeeCount;
import com.example.program.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {


	@Autowired
	EmployeeService employeeService;

	/*@GetMapping
	public ResponseEntity< List<Employee>> getAllEmployees(){
		return ResponseEntity.ok(employeeRepository.findAll());
	}

	@GetMapping("/{employeeid}")
	public ResponseEntity<Employee> getEmployeeByEmployeeId(@PathVariable("employeeid") int employeeid){
		Optional<Employee> personInDB = employeeRepository.findById(employeeid);
		if(personInDB.isPresent()){
			return ResponseEntity.ok(personInDB.get());
		}else{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}*/
	
	@GetMapping("/{managerName}")
	public ResponseEntity<List<EmpolyeeResponseDTO>> getEmployeeBasedManageName(@PathVariable("managerName") String managerName){
		
		
		List<EmpolyeeResponseDTO> personInDB = employeeService.getEmployeeListBasedManage(managerName);
		if(!personInDB.isEmpty()){
			return ResponseEntity.ok(personInDB);
		}else{
			return new ResponseEntity<List<EmpolyeeResponseDTO>>(personInDB,HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<EmpolyeeResponseDTO> createNewEmployee(@RequestBody EmpolyeeDTO person ) throws Exception{


		EmpolyeeResponseDTO empRespDto =   employeeService.createNewEmployee(person);

		return new ResponseEntity<EmpolyeeResponseDTO>(empRespDto,HttpStatus.CREATED);
	}

	
	@GetMapping("/totalEmployee")
	public ResponseEntity<List<EmployeeCount>> getTotalCountBasedManager(){
		
		
		List<EmployeeCount>  personInDB = employeeService.getTotalCountBasedManager();
		if(!personInDB.isEmpty()){
			return ResponseEntity.ok(personInDB);
		}else{
			return new ResponseEntity<List<EmployeeCount>>(personInDB,HttpStatus.NOT_FOUND);
		}
	}

}
