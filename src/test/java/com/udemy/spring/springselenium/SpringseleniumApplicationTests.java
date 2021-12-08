package com.udemy.spring.springselenium;

import com.github.javafaker.Faker;
import com.udemy.spring.springselenium.config.GetList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringseleniumApplicationTests {

	@Autowired
	private User user;

	@Value("${PATH}")
	private String path;

	/*@Value("${name}")
	private List<String> Name;*/

	@Value("${testURL:https://www.google.com}")
	private String Name2;

	@Value("${list}")
	private List<String> list;

	@Autowired
	private Faker faker;

	@Autowired
	private GetList gl;

	@Test
	void contextLoads() {
		//System.out.println(this.list);
		//Faker faker = new Faker();
		System.out.println(gl.list());
	}
}
