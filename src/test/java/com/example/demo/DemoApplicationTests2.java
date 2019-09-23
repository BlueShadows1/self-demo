package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.DemoMapper;
//import com.example.demo.dto.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests2 {

	private JSONObject json = new JSONObject();
	@Autowired
	private TestRestTemplate restTemplate;
//	@Autowired
//	private RedisService redisService;
	@Resource
	private DemoMapper mapper;
	@Test
	public void contextLoads() {
		List<Map> reuslt = mapper.queryUser();
		System.out.printf(reuslt.toString());
	}

	/**
	 * 插入字符串
	 */
//	@Test
//	public void setString() {
//		redisService.set("redis_string_test", "springboot redis test");
//	}
//
//	/**
//	 * 获取字符串
//	 */
//	@Test
//	public void getString() {
//		String result = redisService.get("redis_string_test");
//		System.out.println(result);
//	}
//
//	/**
//	 * 插入对象
//	 */
//	@Test
//	public void setObject() {
//		Person person = new Person("person", "male");
//		redisService.set("redis_obj_test", json.toJSONString(person));
//	}
//
//	/**
//	 * 获取对象
//	 */
//	@Test
//	public void getObject() {
//		String result = redisService.get("redis_obj_test");
//		Person person = json.parseObject(result, Person.class);
//		System.out.println(json.toJSONString(person));
//	}
//
//	/**
//	 * 插入对象List
//	 */
//	@Test
//	public void setList() {
//		Person person1 = new Person("person1", "male");
//		Person person2 = new Person("person2", "female");
//		Person person3 = new Person("person3", "male");
//		List<Person> list = new ArrayList<>();
//		list.add(person1);
//		list.add(person2);
//		list.add(person3);
//		redisService.set("redis_list_test", json.toJSONString(list));
//	}
//
//	/**
//	 * 获取list
//	 */
//	@Test
//	public void getList() {
//		String result = redisService.get("redis_list_test");
//		List<String> list = json.parseArray(result, String.class);
//		System.out.println(list);
//	}
//
//	@Test
//	public void remove() {
//		redisService.remove("redis_test");
//	}


	@Test
	public void token_code() {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("code", "bWieTh");
		String response = restTemplate.withBasicAuth("clientId", "secret").postForObject("/oauth/token", params, String.class);
		System.out.println(response);
	}

	@Test
	public void token_client() {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "client_credentials");
		String response = restTemplate.withBasicAuth("clientId", "secret").
				postForObject("/oauth/token", params, String.class);
		System.out.println(response);
	}
}


