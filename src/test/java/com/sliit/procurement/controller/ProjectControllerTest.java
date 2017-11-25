package com.sliit.procurement.controller;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sliit.procurement.model.Department;
import com.sliit.procurement.model.Project;
import com.sliit.procurement.model.Site;
import com.sliit.procurement.service.ProjectService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProjectController.class, secure = false)
public class ProjectControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProjectService projectService;
	 
	
	@Test
	public void testGetProjectById() throws Exception {
		Project project = new Project();
		project.setProjectId("PRO001");
		project.setProjectNo(1);
		project.setEndDate(new Date(2017, 11, 19));
		project.setStartDate(new Date(2017, 11, 19));
		project.setName("Tiara");
		Site site = new Site();
		site.setSiteNo("SIT001");
		site.setSiteId(1);
		site.setAddress("A2/5 kotehena");
		site.setSiteName("Tiara");
		site.setPersonNo(null);
		project.setSite(site);
		
		Mockito.when(projectService.getProject(Integer.parseInt(Mockito.anyString()))).thenReturn(project);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/project/"+1).accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "{projectNo:1,projectId: PRO001,name:Tiara,startDate: 2016-11-19,endDate: 2017-11-19,site: {siteId: 1,address: A2/5 kotehena,siteName: Tiara,siteNo: SIT001,personNo: null}}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
