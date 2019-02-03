<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,demo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<script src="https://cdn.bootcss.com/jquery/1.9.1/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>王羲之碑帖</title>
</head>
<body>
	<%
	            request.setCharacterEncoding("UTF-8");
	            session = request.getSession(true);//获取会话对象
	            String userName = (String)session.getAttribute("USER_NAME");//从会话中获取客户名
	            if(userName==null){
	                response.sendRedirect("user-login.jsp");
	            }
	        %>
	  <!-- 导航栏 -->
 <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="welcome.jsp">书法馆</a>
    </li>
    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                  王羲之
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">王羲之</a>
        <a class="dropdown-item" href="#">赵孟頫</a>
      </div>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                  碑帖
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="wxzjianjie.jsp">生平</a>
        <a class="dropdown-item" href="word-jizi.jsp">集字</a>
        <a class="dropdown-item" href="word-index.jsp">索引</a>
        <a class="dropdown-item" href="wxzbt.jsp">碑帖</a>
      </div>
    </li>
  </ul>
  <ul class="navbar-nav ml-auto">
  <li class="nav-item active">
      <a class="nav-link" href="welcome.jsp">
      <span class="glyphicon glyphicon-user"></span> Hello, <%=userName%></a>
    </li>
  </ul>
</nav>
<br>
	
	<div class="wrapper">
		<div class="card-columns">
			<%
				java.sql.Connection conn = null;
				java.lang.String strConn;
				java.sql.Statement sqlStmt = null;//语句对象
				java.sql.ResultSet rs = null;//结果集对象
				//try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = java.sql.DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Handwriting",
						"sa", "123456");
				sqlStmt = conn.createStatement();
				System.out.println(conn);
				//执行SQL语句
				String sqlQuery = "SELECT * FROM Rubbing WHERE cno=1";
				rs = sqlStmt.executeQuery(sqlQuery);
				List<Beitie> list = new ArrayList<Beitie>();
				while (rs.next()) {
					int rno = rs.getInt("rno");
					String rname = rs.getString("rname");
					int cno = rs.getInt("cno");
					String rtype = rs.getString("rtype");
					String authority = rs.getString("authority");
					String rpath = rs.getString("rpath");
					//String showpath = rs.getString("showpath");
					Beitie b = new Beitie();
					b.setRno(rno);
					b.setRname(rname);
					//b.rname="cc";
					b.setCno(cno);
					b.setRtype(rtype);
					b.setAuthority(authority);
					b.setRpath(rpath);
					
					//b.setShowpath("images/show/wxz/htj.jpg");
					//b.showpath="images/show/wxz/htj.jpg";
					list.add(b);
				}

				//return list;
				//循环显示数据
				//BeitieDao dao = new BeitieDaoImpl();
				//List<Beitie> list = dao.listBeitie();
				//List<Beitie> list = (List<Beitie>) request.getAttribute("beitielist"); // 取request里面的对象队列
				if (list.size() != 0) {
					for (int i = 0; i < list.size(); i++) {
						pageContext.setAttribute("bt", list.get(i));
						//保存到页面pageContext里面方便下面进行EL表达式调用<img class="card-img-top" src="${bt.showpath} " alt="${bt.rname}">
			%>
			<div class="card" onclick="openPDF()">
				<img class="card-img-top" src="images/show/${bt.rno}.jpg" alt="${bt.rname}">
				<div class="card-body">
					<h5 class="card-title">${bt.rname}</h5>
					<p class="card-text"></p>
					<p class="card-text">
						<small class="text-muted">${bt.rtype}</small> <small
							class="text-muted">${bt.authority}</small>
					</p>
				</div>
				<script>
					function openPDF() {
						var url = "${bt.rpath}";
						window.open("pdfjs/web/viewer.html?file=" + url);
					}
				</script>
			</div>
			<%
				}
				}
			%>
		</div>
	</div>

</body>
</html>