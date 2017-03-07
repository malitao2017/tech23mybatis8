package me.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import me.domain.User;
import me.service.UserServiceI;
/**
 * @WebServlet是servlet3.0提供的注解，目的是将一个继承HttpServlet类的普通java类标注为一个servlet
 * UserServlet使用了@WebServlet之后就不用再web.xml中配置了
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//业务处理类
	private UserServiceI userService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> list = userService.getAllUsers();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
	@Override
	public void init() throws ServletException {
		//servlet初始化时获取spring的上下文对象（ApplicationContext）
		//一般可以直接取类路径获取，这里可以直接从servlet对象获取上下文
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//从ApplicationContext中获取userService
		userService = (UserServiceI) ac.getBean("userService");
	}

}
