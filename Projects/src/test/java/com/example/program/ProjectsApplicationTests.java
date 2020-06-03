package com.example.program;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.program.dto.DivisionDTO;
import com.example.program.dto.DivisionResponseDTO;
import com.example.program.dto.EmpolyeeDTO;
import com.example.program.dto.EmpolyeeResponseDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjectsApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void createEmployee() {

		String empName ="Kanchan"+Math.random();
		int divisionId= 29;
		String managerName ="Yash";

		ResponseEntity<EmpolyeeResponseDTO> responseEntity =

				restTemplate.postForEntity("/employee", new EmpolyeeDTO(BigDecimal.valueOf(100000),"Test Bank",empName,managerName,divisionId), EmpolyeeResponseDTO.class);

		EmpolyeeResponseDTO responseDto = responseEntity.getBody();

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

		assertEquals(empName, responseDto.getEmployeeName());

	}


	@Test
	public void createDivision() {

		String divisionName ="TestDivision"+Math.random();

		String businessName ="Testbuzz"+Math.random();

		String headName = "TestHead"+Math.random();

		ResponseEntity<DivisionResponseDTO> responseEntity =

				restTemplate.postForEntity("/division", new DivisionDTO(divisionName,businessName,headName), DivisionResponseDTO.class);

		DivisionResponseDTO divisionResponseDto = responseEntity.getBody();

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

		assertEquals(divisionName, divisionResponseDto.getDivisionName());

		assertEquals(businessName, divisionResponseDto.getBusiness());

	}


	@Test
	public void getEmployeeForManagerStartName() {

		List<String> managerStartNameList = new ArrayList<String>();

		managerStartNameList.add("R");
		managerStartNameList.add("A");

		managerStartNameList.forEach(startName ->
		{
			ResponseEntity<List> responseEntity =

					restTemplate.getForEntity("/employee/"+startName,List.class);

			//System.out.println("responseEntity.getBody() "+responseEntity.getBody());

			List<LinkedHashMap<String,String>> responseList = (List<LinkedHashMap<String,String>>) responseEntity.getBody();

			assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

			if(responseList!= null && responseList.size()>0)
			{

				responseList.forEach(linkedMap -> {
					//System.out.println(" client.get(0)"+ responseList.get(0));
					//LinkedHashMap<String, String> linkedMap =(LinkedHashMap<String, String>)responseList.get(0);

					String empFirstChar =String.valueOf(linkedMap.get("managerName").charAt(0));

					System.out.println("empFirstChar ::"+empFirstChar);

					System.out.println("startName ::"+startName);
					assertEquals(startName,empFirstChar.toUpperCase());
				});

			}
			else
			{
				Assert.assertTrue(false);
			}
		});

	}


	@Test
	public void getEmployeeListForDivision() {


		HashMap<Integer,String> map = new HashMap<Integer,String>();

		map.put(29, "HR");

		Set<Entry<Integer, String>> entrySet = map.entrySet();

		entrySet.forEach(entry ->
		{

			Integer key = entry.getKey();
			String value = entry.getValue();
			ResponseEntity<List> responseEntity =

					restTemplate.getForEntity("/division/"+value,List.class);

			//System.out.println("responseEntity.getBody() "+responseEntity.getBody());

			List<LinkedHashMap> client = (List<LinkedHashMap>) responseEntity.getBody();

			assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

			if(client!= null && client.size()>0)
			{
				client.forEach(dataMap ->{

					//LinkedHashMap<String, String> linkedMap =(LinkedHashMap<String, String>)client.get(0);

					Integer divisionId = (Integer) dataMap.get("divisionId");
					assertEquals(key,divisionId);
				});

			}
			else
			{
				Assert.assertTrue(false);
			}

		});

	}

	@Test
	public void getTotalCountEachmanager() {


		ResponseEntity<List> responseEntity =

				restTemplate.getForEntity("/division/totalEmployee",List.class);

		//System.out.println("responseEntity.getBody() "+responseEntity.getBody());

		List<LinkedHashMap> responseMap = (List<LinkedHashMap>) responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

		if(responseMap!= null && responseMap.size()>0)
		{
			responseMap.forEach(dataMap ->{

				//LinkedHashMap<String, String> linkedMap =(LinkedHashMap<String, String>)client.get(0);

				Integer empTotalCount =  (Integer) dataMap.get("empTotalCount");
				assertNotEquals("0", empTotalCount+"");
			});

		}
		else
		{
			Assert.assertTrue(false);
		}

	}


	@Test
	public void getManagerBasedOnDivision() {


		HashMap<Integer,String> map = new HashMap<Integer,String>();

		map.put(29, "HR");
		map.put(9, "Tech");

		Set<Entry<Integer, String>> entrySet = map.entrySet();

		entrySet.forEach(entry ->
		{

			Integer key = entry.getKey();
			String value = entry.getValue();
			ResponseEntity<List> responseEntity =

					restTemplate.getForEntity("/division/"+value+"/manager",List.class);

			//System.out.println("responseEntity.getBody() "+responseEntity.getBody());

			List<LinkedHashMap> responseList = (List<LinkedHashMap>) responseEntity.getBody();

			assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

			if(responseList!= null && responseList.size()>0)
			{
				responseList.forEach(dataMap ->{

					//LinkedHashMap<String, String> linkedMap =(LinkedHashMap<String, String>)client.get(0);

					Integer divisionId = (Integer) dataMap.get("divisionId");
					assertEquals(key,divisionId);
				});

			}
			else
			{
				Assert.assertTrue(false);
			}

		});
	}

	@Test
	public void getEmpolyeeCountManagerWise() {

		ResponseEntity<List> responseEntity =

				restTemplate.getForEntity("/employee/totalEmployee",List.class);

		//System.out.println("responseEntity.getBody() "+responseEntity.getBody());

		List<LinkedHashMap> responseList = (List<LinkedHashMap>) responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

		if(responseList!= null && responseList.size()>0)
		{
			responseList.forEach(dataMap ->{

				//LinkedHashMap<String, String> linkedMap =(LinkedHashMap<String, String>)client.get(0);

				Integer total = (Integer) dataMap.get("total");
				assertNotEquals(0+"",total+"");
			});

		}
		else
		{
			Assert.assertTrue(false);
		}
	}

}
