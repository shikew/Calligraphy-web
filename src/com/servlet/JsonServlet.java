package com.servlet;

import java.io.*;
import com.utils.*;
import java.sql.*;
 
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
//说明这个Servlet是没有序列号的
@SuppressWarnings("serial")
//说明这个Servlet的名称是jsonRequest，其地址是/jsonRequest这与在web.xml中设置是一样的
@WebServlet(name = "jsonRequest", urlPatterns = { "/jsonRequest" })
public class JsonServlet extends HttpServlet {
	//放置用户之间通过直接在浏览器输入地址访问这个servlet
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintStream out = new PrintStream(response.getOutputStream());
		response.setContentType("text/html;charSet=gb2312");
		out.print("请正常打开此页");
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//把从数据库的查询结果构造一个json字符串推向前台
		StringBuffer json = new StringBuffer();
		json.append("[");
		try {
			dbDAO db = new dbDAO();
			ResultSet rs = db.query("select * from Word");
			while (rs.next()) {
				json.append('{');
				//注意每一个key-value对都要在引号之中，单引号或者双引号都可以
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
		//这是为了删除最后一次循环中出现的那个逗号
		json.deleteCharAt(json.length() - 1);
		json.append("]");
		PrintStream out = new PrintStream(response.getOutputStream());
		response.setContentType("text/javascript;charSet=gb2312");
		response.setCharacterEncoding("gb2312");
		//搞完把json打印在本Servlet上，之后前台页面读这页的内容就可以了
		out.println(json.toString());
		out.close();
	}
}


