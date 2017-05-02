
/*클라이언트의 요청이 get, post이던 섞여서 들어올 경우 서버의 대응방법*/

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

	//get or post이던 어떤 종류의 요청이 들어오더라도 하나의 진입점으로 몰아버리면 코드의 중복을 방지할 수 있다.
	public void doRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		int x=3;
		int y=5;
		int sum=x+y;

		PrintWriter out=response.getWriter();
		out.print("계산결과는 "+sum);
	}





} 
