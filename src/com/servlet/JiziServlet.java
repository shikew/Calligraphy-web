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
@WebServlet(name = "JiziServlet", urlPatterns = { "/jiziServlet" })
public class JiziServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数 method
		String method = request.getParameter("method");
		
		System.out.println("获取到的method参数为： " + method);
		//调用 method 方法
		if(method.equals("querybyJizi")) {
			this.querybyJizi(request, response);
		}else if(method.equals("querybyRandom")) {
			this.querybyRandom(request, response);
		}
	}
	
	private void querybyJizi(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
				StringBuffer json = new StringBuffer();
				json.append("[");
		        response.setContentType("application/json;charset=utf-8");
		        String jiziContent = request.getParameter("jiziContent");
		        	try {
		        		dbDAO db = new dbDAO();
		        		ResultSet rs = null;
		        		for(int i=0;i<jiziContent.length();i++) {
		        			char ch = jiziContent.charAt(i);
							String sql = "select rname,wpath from wxz_xingshu where wname='"+ch+"'";
							rs = db.query(sql);
							while (rs.next()) {
								json.append('{');
								json.append("'rname':").append("'")
										.append(rs.getString("rname").trim()).append("'").append(",");
								json.append("'wpath':").append("'")
										.append(rs.getString("wpath").trim()).append("'");
								json.append("},");
							}			
		        		}
					} catch (Exception e) {
						e.printStackTrace();
					}
		        	json.deleteCharAt(json.length() - 1);
		    		json.append("]");
		    		System.out.println("集字返回："+json);
		    		PrintStream out = new PrintStream(response.getOutputStream());
		    		response.setContentType("text/javascript;charSet=gb2312");
		    		response.setCharacterEncoding("gb2312");
		    		//把json打印在本Servlet上，之后前台页面读这页的内容就可以了
		    		out.println(json.toString());
		    		out.close();
	}
	
	private void querybyRandom(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		StringBuffer json = new StringBuffer();
		json.append("[");
		try {
			dbDAO db = new dbDAO();
			String vsentence = "";
			ResultSet rss = null;      //存放最后要展示的查询结构
			ResultSet rs = db.query("select top 1.vsentence from Verse order by newid() ");
			while (rs.next()) {
				vsentence = rs.getString("vsentence");
			}
			System.out.println("随机诗词："+vsentence);
			for(int i =0;i<vsentence.length();i++) {
		           char ch = vsentence.charAt(i);
		           String sql = "select Rubbing.rname,wpath from Word,Rubbing where Word.rno = Rubbing.rno AND wname='"+ch+"'";
		           rss = db.query(sql);
		           while (rss.next()) {
						json.append('{');
						json.append("'rname':").append("'")
								.append(rss.getString("rname").trim()).append("'").append(",");
						json.append("'wpath':").append("'")
								.append(rss.getString("wpath").trim()).append("'");
						json.append("},");
					}			
			}
			System.out.println("Random返回："+json);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		//删除最后一个循环后的逗号
		json.deleteCharAt(json.length() - 1);
		json.append("]");
		PrintStream out = new PrintStream(response.getOutputStream());
		response.setContentType("text/javascript;charSet=gb2312");
		response.setCharacterEncoding("gb2312");
		out.println(json.toString());
		out.close();
	}
	
}

