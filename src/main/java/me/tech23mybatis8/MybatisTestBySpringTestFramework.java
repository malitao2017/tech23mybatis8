package me.tech23mybatis8;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.domain.User;
import me.service.UserServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
//配置了@ContextConfiguration注解并使用该注解的location属性 指明 执行spring的配置文件
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class MybatisTestBySpringTestFramework {
//	注入userService
	@Autowired
	private UserServiceI userService;
	
	@Test
	public void testAddUser(){
		User user = new User();
		String userId = UUID.randomUUID().toString().replaceAll("-", "");
		user.setUserId(userId);
		user.setUserBirthday(new Date());
		user.setUserName("李四");
		user.setUserSalary(1000D);
		userService.addUser(user);
		
		User u= userService.getUserById(userId);
		System.out.println(u);
	}
}
