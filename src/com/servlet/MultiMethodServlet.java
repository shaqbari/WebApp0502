
/*Ŭ���̾�Ʈ�� ��û�� get, post�̴� ������ ���� ��� ������ �������*/

package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;

public class MultiMethodServlet extends HttpServlet{
	//get

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doRequest(request, response);
	}

	//post
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doRequest(request, response);
	}

	//get or post�̴� � ������ ��û�� �������� �ϳ��� ���������� ���ƹ����� �ڵ��� �ߺ��� ������ �� �ִ�.
	public void doRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		int x=3;
		int y=5;
		int sum=x+y;

		PrintWriter out=response.getWriter();
		out.print("������� "+sum);
	}





} 
