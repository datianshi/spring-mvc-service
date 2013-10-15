package com.sample.mvc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.sample.domain.EmbededBean;
import com.sample.domain.MyBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class IntegrationTest {
	@Autowired
	private RestTemplate restTemplate;
	
	private final String URL;
	
	
	public IntegrationTest(){
		URL = System.getProperty("integrationUrl") + "/rest";
	}
	
	@Test
	public void getRestTemplate(){
		Assert.assertNotNull(restTemplate);
	}
	
	@Test
	public void get(){
		MyBean bean = new MyBean();
		bean.setName("Hello");
		EmbededBean eb = new EmbededBean();
		eb.setName("eb");
		bean.setEb(eb);
		
		
		restTemplate.postForObject(URL, bean, String.class);		
		String ret = restTemplate.getForObject(URL + "/Hello", String.class);
		Assert.assertNotNull(ret);
	}
	
	@Test
	public void delete(){
		restTemplate.delete(URL + "/Hello");
		String ret = restTemplate.getForObject(URL + "/Hello", String.class);
		Assert.assertNull(ret);
	}	

	
}
