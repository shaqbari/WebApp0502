/*������ �����ֱ� �޼ҵ���, ��ü�� �ν��Ͻ��� �ö�ö� �� 1�� ȣ��Ǵ� �ʱ�ȭ �޼ҵ��� 
	init()�� �μ��� ���޵Ǵ� ��ü�� ServletConfig�� �̿��� ����!!*/

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

	//�� ���� Ŭ������ �ν��Ͻ��� ���ʿ� �޸𸮿� �ö�ö� �� 1�� ȣ��Ǵ� �޼ҵ��� init������
	public void init(ServletConfig config){
		url=config.getInitParameter("url");
		user=config.getInitParameter("user");
		password=config.getInitParameter("password");
		//���⼭�� response�� ���� ����.
	}

	//���񽺸޼ҵ�� �������� �ʿ䰡 ����!

	//get����� ��û�� ���ö� ȣ��Ǵ� �޼ҵ�
	public void doGet(HttpServletRequest reqeust, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		PrintWriter out=response.getWriter();
		out.print(url+"<br>");
		out.print(user+"<br>");
		out.print(password+"<br>");
	}

	//�ν��Ͻ��� �Ҹ�ɶ� ȣ��Ǵ� �޼ҵ�!
	public void destroy(){
	
	}
	
}
