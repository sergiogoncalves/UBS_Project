package com.ubs.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ubs.domainvalue.Messages;

import org.springframework.http.MediaType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class CartControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void shouldReturnACreatedStatus() throws Exception {
		
		this.mvc.perform(post("/cart")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(Messages.CART_DTO_STRING))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void shouldReturnErrorStatus() throws Exception {
		
		this.mvc.perform(get("/cart/1000")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void shouldReturnOKStatusOnGetAll() throws Exception {
		
		this.mvc.perform(get("/cart")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturnOkStatusOnGetCart() throws Exception {
		
		this.mvc.perform(get("/cart/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturnOkOnDeleteCart() throws Exception {
		
		this.mvc.perform(delete("/cart/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturnErrorOnDeleteCart() throws Exception {
		
		this.mvc.perform(delete("/cart/100")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());
	}
	


}
