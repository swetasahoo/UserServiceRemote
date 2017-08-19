package com.stackroute.activitystream.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.activitystream.UserService.UserServiceApplication;
import com.stackroute.activitystream.dao.UserDao;
import com.stackroute.activitystream.model.User;
import com.stackroute.activitystream.restcontroller.UserController;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { UserServiceApplication.class })
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT,classes=UserServiceApplication.class)
public class UserControllerTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;


	@Autowired
	 UserDao userDAO;
	
	@Before
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	@Ignore
	@Test
	public void alluser() throws Exception {
		//"http://localhost:9012/api/user/authenticate"
	    		this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:9012/api/user/allusers"))
	    		.andExpect(status().isOk());
	    			       
	    	  
	}
	
	private static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  
	
	@Ignore
	@Test
	public void testValidateUser_NoError() throws Exception {
		User user=new User();
		user.setEmailId("sweta@gmail.com");
		user.setPassword("password");
		
		mockMvc.perform(post("http://localhost:9012/api/user/login").content(asJsonString(user)).contentType(MediaType.APPLICATION_JSON)
				  .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
	@Ignore
	@Test
	public void testValidateUser_Error() throws Exception {
		User user=new User();
		user.setEmailId("swe@gmail.com");
		user.setPassword("password");
		
		mockMvc.perform(post("http://localhost:9012/api/user/login").content(asJsonString(user)).contentType(MediaType.APPLICATION_JSON)
				  .accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
		
	}

	@Test
	public void testGetUser_NOError() throws Exception
	{
		User user=new User();
		user.setEmailId("sweta@gmail.com");
		mockMvc.perform(post("http://localhost:9012/api/user/getUser").content(asJsonString(user)).contentType(MediaType.APPLICATION_JSON)
				  .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
	@Ignore
	@Test
	public void testGetUser_Error() throws Exception
	{
		User user=new User();
		user.setEmailId("swet@gmail");
		mockMvc.perform(post("http://localhost:9012/api/user/getUser").content(asJsonString(user)).contentType(MediaType.APPLICATION_JSON)
				  .accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
		
	}
@Ignore
	@Test
	public void testCreateUser_NOError() throws Exception
	{
		User user=new User();
		user.setEmailId("amit@gmail.com");
		user.setPassword("p@ssword");
		user.setAddress("combaiture");
		user.setPhoneNo("9963256333");
		user.setName("Vijay");
		
		
		mockMvc.perform(post("http://localhost:9012/api/user/create").content(asJsonString(user)).contentType(MediaType.APPLICATION_JSON)
				  .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}


}
