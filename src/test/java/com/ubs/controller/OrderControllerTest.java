package com.ubs.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ubs.datatransferobject.OrderDTO;
import com.ubs.domainvalue.Messages;
import com.ubs.util.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class OrderControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void shouldReturnWriteJsonAndOkStatus() throws Exception {
		
		this.mvc.perform(get("/order/2")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());		
		
	}
	
	@Test
	public void shouldReturn400Status() throws Exception {
		
		this.mvc.perform(get("/order/1000")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void shouldReturnCreateAnd200StatusOnPost() throws Exception {
		
		this.mvc.perform(post("/order")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(Messages.ORDER_DO_STRING_ID_02))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void shouldReturn200StatusOnPut() throws Exception {
		
		this.mvc.perform(put("/order")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(Messages.ORDER_DTO_STRING))
				.andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturn200StatusOnDelete() throws Exception {
		
		
		this.mvc.perform(delete("/order/1")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

}
