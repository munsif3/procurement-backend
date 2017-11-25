package com.sliit.procurement.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sliit.procurement.model.Department;
import com.sliit.procurement.service.DepartmentService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DepartmentController.class, secure = false)
public class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DepartmentService departmentService;

	public void testListAllUsers() throws Exception {

	}

	@Test
	public void createDepartment() throws Exception {
		Department department = new Department();
		department.setDepartmentName("eagOLD");
		
		Mockito.when(departmentService.saveDepartment(Mockito.any(Department.class))).thenReturn(department);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/department")
				.accept(MediaType.APPLICATION_JSON).content("{\"departmentName\": \"eagOLD\"}")
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}

	public void testUpdateDepartment() {
		fail("Not yet implemented");
	}

}
