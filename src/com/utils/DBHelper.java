package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class DBHelper {
		public static void main(String [] args)
		 {
		  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		  String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Handwriting";
		  String userName="sa";
		  String userPwd="123456";
		 try
		{
		    Class.forName(driverName);
		    System.out.println("���������ɹ���");
		}catch(Exception e){
		    e.printStackTrace();
		    System.out.println("��������ʧ�ܣ�");
		}
		try{
		    Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		        System.out.println("�������ݿ�ɹ���");
		}catch(Exception e)
		{
		    e.printStackTrace();
		    System.out.print("SQL Server����ʧ�ܣ�");
		}        
		}

 
}

