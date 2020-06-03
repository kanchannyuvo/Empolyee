package com.example.program.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.program.dto.DivisionDTO;
import com.example.program.dto.DivisionResponseDTO;
import com.example.program.dto.EmpolyeeResponseDTO;
import com.example.program.exception.EmployeeNotFoundException;
import com.example.program.model.Division;
import com.example.program.model.DivisionCount;
import com.example.program.model.EmployeeCount;
import com.example.program.service.DivisionService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/division")
public class DivisionController {


	@Autowired
	DivisionService divisionService;
	
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
	
	@ApiOperation(value = "Create Division", response = DivisionDTO.class)
	@PostMapping
	public ResponseEntity<DivisionResponseDTO> createNewDivision(@RequestBody DivisionDTO divisionDto) throws Exception{
		
		DivisionResponseDTO divisionDB = divisionService.createNewDivision(divisionDto);
		
		if(divisionDB==null)
		{
			return new ResponseEntity<DivisionResponseDTO>(divisionDB,HttpStatus.BAD_REQUEST);
			
		}
		
		HttpStatus httpStatus = HttpStatus.CREATED;
		
		if(divisionDB.getMessage().equalsIgnoreCase("Record Already Present"))
		{
			httpStatus=HttpStatus.CONFLICT;
		}
		
		return new ResponseEntity<DivisionResponseDTO>(divisionDB,httpStatus);
	}
	
	
	@GetMapping("/{divisionName}")
	public ResponseEntity<List<EmpolyeeResponseDTO>> getEmployeeByDivision(@PathVariable("divisionName") String divisionName){
		
		
		List<EmpolyeeResponseDTO> employeeList = divisionService.getEmployeeByDivision(divisionName);
		if(!employeeList.isEmpty()){
			return ResponseEntity.ok(employeeList);
		}else{
			return new ResponseEntity<List<EmpolyeeResponseDTO>>(employeeList,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{divisionName}/manager")
	public ResponseEntity<Set<EmpolyeeResponseDTO>> getManagerByDivision(@PathVariable("divisionName") String divisionName){
		
		
		Set<EmpolyeeResponseDTO> employeeList = divisionService.getManagerByDivision(divisionName);
		if(!employeeList.isEmpty()){
			return ResponseEntity.ok(employeeList);
		}else{
			return new ResponseEntity<Set<EmpolyeeResponseDTO>>(employeeList,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/totalEmployee")
	public ResponseEntity<List<DivisionCount>> getTotalCountBasedDivision(){
		
		
		List<DivisionCount>  personInDB = divisionService.getTotalCountBasedDivision();
		if(!personInDB.isEmpty()){
			return ResponseEntity.ok(personInDB);
		}else{
			return new ResponseEntity<List<DivisionCount>>(personInDB,HttpStatus.NOT_FOUND);
		}
	}
	


}
