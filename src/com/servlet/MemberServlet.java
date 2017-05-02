//�� Ŭ������ �� �����󿡼��� �ؼ� �� �����ϰ� ������̴�.

package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;//http��������.
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberServlet extends HttpServlet{
	//�� Ŭ���̾�Ʈ�� ��û�� ������ �޼ҵ� ����
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="bread";
	String password="bread";
	
	Connection con;
	PreparedStatement pstmt;	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		/*����) throw:���� �޼ҵ忡�� �߻��� ������ ó������ �ʰ�, �̸޼ҵ带 ȣ���� ȣ��ο� ���� ��ü�� �����ϴ� ���*/
		
		response.setContentType("text/html");
		//Ŭ���̾�Ʈ�� �������� ��Ʈ������ �����͸� ������ �ѱ��� ���� ���� ��� ������ �ʵ��� ó��
		response.setCharacterEncoding("utf-8");

		//����� ���Ǵ� ��Ʈ���� �̿��Ͽ�, ���ڿ� ���
		PrintWriter out=response.getWriter();
		out.print("member���� �۵��Ѵ�.");

		//��û�� �õ��� Ŭ���̾�Ʈ�� ���� ������(�Ķ���Ͱ�)�� �޾ƺ���!
		//Ŭ���̾�Ʈ�� ������ �Ķ���Ͱ��鿡 �ѱ��� ������� ��� ������ �ʵ��� ó��
		request.setCharacterEncoding("utf-8");
		String p1=request.getParameter("id");
		String p2=request.getParameter("password");
		String p3=request.getParameter("name");
		
		out.print("�Ѱܹ��� id��"+p1);
		out.print("�Ѱܹ��� pw��"+p2);
		out.print("�Ѱܹ��� name��"+p3);
	
		String sql="insert into member2(member2_id, id, password, name) values(seq_member2.nextVal, ?, ?, ?)";
		out.print("�ߵǳ�?"+sql);
		
		try{
			Class.forName(driver);

			con=DriverManager.getConnection(url, user, password);
			if (con!=null)	{
				out.println("���Ӽ���");
			}

			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, p1);
			pstmt.setString(2, p2);
			pstmt.setString(3, p3);
			int result=pstmt.executeUpdate();
			
			if (result==1){
				out.print("�Է� ����");
				out.print("<script>");
				out.print("alert(\"db�� �Է¼����߽��ϴ�.\");");			
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
