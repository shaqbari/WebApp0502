/*서블릿의 생명주기 메소드중, 객체의 인스턴스가 올라올때 딱 1번 호출되는 초기화 메소드인 
	init()에 인수로 전달되는 객체인 ServletConfig를 이용해 보자!!*/

package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;

public class DDTest extends HttpServlet{
	String url;
	String user;
	String password;

	//이 서블릿 클래스의 인스턴스가 최초에 메모리에 올라올때 딱 1번 호출되는 메소드인 init재정의
	public void init(ServletConfig config){
		url=config.getInitParameter("url");
		user=config.getInitParameter("user");
		password=config.getInitParameter("password");
		//여기서는 response를 쓸수 없다.
	}

	//서비스메소드는 재정의할 필요가 없다!

	//get방식의 요청이 들어올때 호출되는 메소드
	public void doGet(HttpServletRequest reqeust, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		PrintWriter out=response.getWriter();
		out.print(url+"<br>");
		out.print(user+"<br>");
		out.print(password+"<br>");
	}

	//인스턴스가 소멸될때 호출되는 메소드!
	public void destroy(){
	
	}
	
}
