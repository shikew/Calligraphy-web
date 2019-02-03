package com.utils;
import java.sql.*;
 
public class dbDAO {
	private Connection con;
 
	// ���캯�����������ݿ�
	public dbDAO() throws Exception {
		String dburl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Handwriting";
		String dbusername = "sa";
		String dbpassword = "123456";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		this.con = DriverManager.getConnection(dburl, dbusername, dbpassword);
	}
 
	// ִ�в�ѯ
	public ResultSet query(String sql, Object... args) throws Exception {
		PreparedStatement ps = con.prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			ps.setObject(i + 1, args[i]);
		}
		return ps.executeQuery();
	}
 
	// ִ�в���
	public boolean insert(String sql, Object... args) throws Exception {
		PreparedStatement ps = con.prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			ps.setObject(i + 1, args[i]);
		}
		if (ps.executeUpdate() != 1) {
			return false;
		}
		return true;
	}
 
	// ִ���޸�
	public boolean modify(String sql, Object... args) throws Exception {
		PreparedStatement ps = con.prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			ps.setObject(i + 1, args[i]);
		}
		if (ps.executeUpdate() != 1) {
			return false;
		}
		return true;
	}
 
	// �����������ж����ݿ������
	protected void finalize() throws Exception {
		if (!con.isClosed() || con != null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		try
		{
			dbDAO db = new dbDAO();
			ResultSet rs = db.query("select * from Word");
			System.out.println(rs);
		}catch(Exception e){
		    e.printStackTrace();
		    System.out.println("��������ʧ�ܣ�");
		}
		
	}
}
