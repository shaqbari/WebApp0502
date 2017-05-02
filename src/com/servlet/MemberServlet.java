//이 클래스는 웹 서버상에서만 해석 및 실행하게 만들것이다.

package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;//http가빠진다.
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberServlet extends HttpServlet{
	//웹 클라이언트의 요청시 동작할 메소드 정의
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="bread";
	String password="bread";
	
	Connection con;
	PreparedStatement pstmt;	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		/*참고) throw:현재 메소드에서 발생된 에러를 처리하지 않고, 이메소드를 호출한 호출부에 예외 객체를 전달하는 기능*/
		
		response.setContentType("text/html");
		//클라이언트의 브라우저에 스트림으로 데이터를 보낼때 한글이 섞여 있을 경우 깨지지 않도록 처리
		response.setCharacterEncoding("utf-8");

		//응답시 사용되는 스트림을 이용하여, 문자열 출력
		PrintWriter out=response.getWriter();
		out.print("member서블릿 작동한다.");

		//요청을 시도한 클라이언트가 보낸 데이터(파라미터값)을 받아보자!
		//클라이언트가 전송한 파라미터값들에 한글이 들어있을 경우 깨지지 않도록 처리
		request.setCharacterEncoding("utf-8");
		String p1=request.getParameter("id");
		String p2=request.getParameter("password");
		String p3=request.getParameter("name");
		
		out.print("넘겨받은 id는"+p1);
		out.print("넘겨받은 pw는"+p2);
		out.print("넘겨받은 name는"+p3);
	
		String sql="insert into member2(member2_id, id, password, name) values(seq_member2.nextVal, ?, ?, ?)";
		out.print("잘되나?"+sql);
		
		try{
			Class.forName(driver);

			con=DriverManager.getConnection(url, user, password);
			if (con!=null)	{
				out.println("접속성공");
			}

			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, p1);
			pstmt.setString(2, p2);
			pstmt.setString(3, p3);
			int result=pstmt.executeUpdate();
			
			if (result==1){
				out.print("입력 성공");
				out.print("<script>");
				out.print("alert(\"db에 입력성공했습니다.\");");			
				out.print("</script>");
			}

		}catch(ClassNotFoundException e){
		
		}catch(SQLException e){
		
		}finally{
			if (pstmt!=null){				
				try{
					pstmt.close();				
				}catch(SQLException e){
				
				}				
			}
		}


	}
}
