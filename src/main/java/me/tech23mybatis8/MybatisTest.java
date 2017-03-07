package me.tech23mybatis8;

import java.util.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.domain.User;
import me.service.UserServiceI;

/**
 * Hello world!
 *
 */
public class MybatisTest{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
    }
    
    private UserServiceI userService;
    
//    这个before方法在所有的测试方法之前执行，并且只执行一次
//    所有做Junit单元测试时的一些初始化工作可以在这个方法执行
//    比如在before方法里面初始化ApplicationContext和userService
    @SuppressWarnings("resource")
	@Before
    public void before(){
//    	使用spring.xml和spring-mybatis.xml这俩个配置文件创建Spring上下文
    	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
//    	从Spring容器中更具bean的id取出我们要使用的userService对象
    	userService = (UserServiceI) ac.getBean("userService");
    }
    
    @Test
    public void testAddUser(){
    	//ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
    	//userService = (UserServiceI) ac.getBean("userService");
    	User user = new User();
//    	user.setUserId();
    	String id = UUID.randomUUID().toString();
    	String userId = id.replaceAll("-", "");
    	user.setUserId(userId);
    	user.setUserBirthday(new Date());
    	user.setUserName("张三");
    	user.setUserSalary(10.1);
    	userService.addUser(user);
    	
    	User u = userService.getUserById(userId);
    	System.out.println("存入的数据为："+u);
    	System.out.println("uuid原生:" +id);
    }
}
