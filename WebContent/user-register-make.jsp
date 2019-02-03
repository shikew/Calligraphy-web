<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>客户注册是否合法</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String userName = request.getParameter("username"); 
            String password = request.getParameter("password");
            String userEmail = request.getParameter("useremail");
            String userTelNo = request.getParameter("usertelno");
            java.sql.Connection conn = null;
            java.lang.String strConn;
            java.sql.Statement sqlStmt = null;//语句对象
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = java.sql.DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Handwriting","sa","123456");
            sqlStmt = conn.createStatement();
            //执行SQL语句
            try{
            	if((userName!=null&&userName.length()!=0)&&(password!=null&&password.length()!=0)&&(userEmail!=null&&userEmail.length()!=0)&&(userTelNo!=null&&userTelNo.length()!=0)){
                    String sql = "INSERT INTO AllUser(login_name,password,email,mobile) VALUES('"+userName+"','"+password+"','"+userEmail+"','"+userTelNo+"')"; 
                    sqlStmt.executeUpdate(sql);
                    sqlStmt.close();
                    conn.close();
                    response.sendRedirect("user-login.jsp");
                }else{
                    response.sendRedirect("user-register.jsp");
                }
            }catch (Exception e) {
				e.printStackTrace();
			}
        %>
    </body>
</html>
