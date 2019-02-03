package com.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.dbDAO;

/**
 * Servlet implementation class StaffServlet
 */
@WebServlet(name = "IndexServlet", urlPatterns = { "/indexServlet" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数 method
		String method = request.getParameter("method");
		
		System.out.println("获取到的method参数为： " + method);
		//调用 method 方法
		if(method.equals("querybyA")) {
			this.querybyA(request, response);
		}else if(method.equals("querybyB")) {
			this.querybyB(request, response);
		}else if(method.equals("querybyC")) {
			this.querybyC(request, response);
		}else if(method.equals("querybyH")) {
			this.querybyH(request, response);}
	}
	
	private void querybyA(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		//把从数据库的查询结果构造一个json字符串推向前台
				StringBuffer json = new StringBuffer();
				json.append("[");
				try {
					dbDAO db = new dbDAO();
					ResultSet rs = db.query("select wno,wname,wspell,Rubbing.rname,Rubbing.rtype,wpath from Word,Rubbing where Word.rno = Rubbing.rno AND wspell LIKE 'a%' order by wspell desc");
					while (rs.next()) {
						json.append('{');
						//注意每一个key-value对都要在引号之中，单引号或者双引号都可以
						json.append("'wno':").append("'").append(rs.getInt("wno")).append("'").append(",");
						json.append("'wname':").append("'")
								.append(rs.getString("wname").trim()).append("'").append(",");
						json.append("'rtype':").append("'")
						.append(rs.getString("rtype").trim()).append("'").append(",");
						json.append("'rname':").append("'")
						.append(rs.getString("rname").trim()).append("'").append(",");
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
	
	private void querybyB(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		StringBuffer json = new StringBuffer();
		json.append("[");
		try {
			dbDAO db = new dbDAO();
			ResultSet rs = db.query("select wno,wname,wspell,Rubbing.rname,Rubbing.rtype,wpath from Word,Rubbing where Word.rno = Rubbing.rno AND wspell LIKE 'b%' order by wspell desc");
			while (rs.next()) {
				json.append('{');
				json.append("'wno':").append("'").append(rs.getInt("wno")).append("'").append(",");
				json.append("'wname':").append("'")
						.append(rs.getString("wname").trim()).append("'").append(",");
				json.append("'rtype':").append("'")
				.append(rs.getString("rtype").trim()).append("'").append(",");
				json.append("'rname':").append("'")
				.append(rs.getString("rname").trim()).append("'").append(",");
				json.append("'wpath':").append("'")
						.append(rs.getString("wpath").trim()).append("'");
				json.append("},");
			}			
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		json.deleteCharAt(json.length() - 1);
		json.append("]");
		PrintStream out = new PrintStream(response.getOutputStream());
		response.setContentType("text/javascript;charSet=gb2312");
		response.setCharacterEncoding("gb2312");
		out.println(json.toString());
		out.close();
	}
	
	private void querybyC(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		StringBuffer json = new StringBuffer();
		json.append("[");
		try {
			dbDAO db = new dbDAO();
			ResultSet rs = db.query("select wno,wname,wspell,Rubbing.rname,Rubbing.rtype,wpath from Word,Rubbing where Word.rno = Rubbing.rno AND wspell LIKE 'c%' order by wspell desc");
			while (rs.next()) {
				json.append('{');
				//注意每一个key-value对都要在引号之中，单引号或者双引号都可以
				json.append("'wno':").append("'").append(rs.getInt("wno")).append("'").append(",");
				json.append("'wname':").append("'")
						.append(rs.getString("wname").trim()).append("'").append(",");
				json.append("'rtype':").append("'")
				.append(rs.getString("rtype").trim()).append("'").append(",");
				json.append("'rname':").append("'")
				.append(rs.getString("rname").trim()).append("'").append(",");
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
	
	private void querybyH(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		StringBuffer json = new StringBuffer();
		json.append("[");
		try {
			dbDAO db = new dbDAO();
			ResultSet rs = db.query("select wno,wname,wspell,Rubbing.rname,Rubbing.rtype,wpath from Word,Rubbing where Word.rno = Rubbing.rno AND wspell LIKE 'h%' order by wspell desc");
			while (rs.next()) {
				json.append('{');
				json.append("'wno':").append("'").append(rs.getInt("wno")).append("'").append(",");
				json.append("'wname':").append("'")
						.append(rs.getString("wname").trim()).append("'").append(",");
				json.append("'rtype':").append("'")
				.append(rs.getString("rtype").trim()).append("'").append(",");
				json.append("'rname':").append("'")
				.append(rs.getString("rname").trim()).append("'").append(",");
				json.append("'wpath':").append("'")
						.append(rs.getString("wpath").trim()).append("'");
				json.append("},");
			}			
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		json.deleteCharAt(json.length() - 1);
		json.append("]");
		PrintStream out = new PrintStream(response.getOutputStream());
		response.setContentType("text/javascript;charSet=gb2312");
		response.setCharacterEncoding("gb2312");
		out.println(json.toString());
		out.close();
	}
	
}

