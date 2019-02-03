package com.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.UrlMapping;
import com.utils.dbDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述:
 * 具体处理请求
 */

public class Collectors {
    @UrlMapping("/jsonARequest")
    public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
    
    @UrlMapping("/regist")
    public void regist(HttpServletRequest request, HttpServletResponse response){
        System.out.println(".....");
    }

}