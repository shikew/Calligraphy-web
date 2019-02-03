package com.servlet;

import java.io.*;
import com.utils.*;
import java.sql.*;
 
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
//˵�����Servlet��û�����кŵ�
@SuppressWarnings("serial")
//˵�����Servlet��������jsonRequest�����ַ��/jsonRequest������web.xml��������һ����
@WebServlet(name = "jsonRequest", urlPatterns = { "/jsonRequest" })
public class JsonServlet extends HttpServlet {
	//�����û�֮��ͨ��ֱ��������������ַ�������servlet
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintStream out = new PrintStream(response.getOutputStream());
		response.setContentType("text/html;charSet=gb2312");
		out.print("�������򿪴�ҳ");
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//�Ѵ����ݿ�Ĳ�ѯ�������һ��json�ַ�������ǰ̨
		StringBuffer json = new StringBuffer();
		json.append("[");
		try {
			dbDAO db = new dbDAO();
			ResultSet rs = db.query("select * from Word");
			while (rs.next()) {
				json.append('{');
				//ע��ÿһ��key-value�Զ�Ҫ������֮�У������Ż���˫���Ŷ�����
				json.append("'wno':").append("'").append(rs.getInt("wno")).append("'").append(",");
				json.append("'wname':").append("'")
						.append(rs.getString("wname").trim()).append("'").append(",");
				json.append("'rtype':").append("'")
				.append(rs.getString("rtype").trim()).append("'").append(",");
				json.append("'wpath':").append("'")
						.append(rs.getString("wpath").trim()).append("'");
				json.append("},");
			}			
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		//����Ϊ��ɾ�����һ��ѭ���г��ֵ��Ǹ�����
		json.deleteCharAt(json.length() - 1);
		json.append("]");
		PrintStream out = new PrintStream(response.getOutputStream());
		response.setContentType("text/javascript;charSet=gb2312");
		response.setCharacterEncoding("gb2312");
		//�����json��ӡ�ڱ�Servlet�ϣ�֮��ǰ̨ҳ�����ҳ�����ݾͿ�����
		out.println(json.toString());
		out.close();
	}
}


