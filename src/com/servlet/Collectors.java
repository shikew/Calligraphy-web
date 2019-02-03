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
 * ����:
 * ���崦������
 */

public class Collectors {
    @UrlMapping("/jsonARequest")
    public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
    
    @UrlMapping("/regist")
    public void regist(HttpServletRequest request, HttpServletResponse response){
        System.out.println(".....");
    }

}