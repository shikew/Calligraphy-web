<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>王羲之-索引</title>
        <link rel="stylesheet" href="css/style.css" />
        <script src="https://cdn.bootcss.com/jquery/1.9.1/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
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
		                   索引
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
      	<a class="nav-link" href="#">
     	 <span class="glyphicon glyphicon-user"></span> Hello, <%=userName%></a>
    	</li>
  		</ul>
		</nav>
		<br>
		
        <div class="wrapper">
            <div class="header">
                <h1>集字索引</h1>
                <h2>选择你想要查看的索引</h2>
            </div>
            <div class="content">
                <div class="btn-group" style="margin-top:30px;">
                <button type="button" class="btn btn-outline-dark" onclick="onclick_a()" style="width:40px;">A</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_b()" style="width:40px;">B</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_c()" style="width:40px;">C</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_d()" style="width:40px;">D</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_e()" style="width:40px;">E</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_f()" style="width:40px;">F</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_g()" style="width:40px;">G</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_h()" style="width:40px;">H</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_i()" style="width:40px;">I</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_j()" style="width:40px;">J</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_k()" style="width:40px;">K</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_l()" style="width:40px;">L</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_m()" style="width:40px;">M</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_n()" style="width:40px;">N</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_o()" style="width:40px;">O</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_p()" style="width:40px;">P</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_q()" style="width:40px;">Q</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_r()" style="width:40px;">R</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_s()" style="width:40px;">S</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_t()" style="width:40px;">T</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_u()" style="width:40px;">U</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_v()" style="width:40px;">V</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_w()" style="width:40px;">W</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_x()" style="width:40px;">X</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_y()" style="width:40px;">Y</button>
				<button type="button" class="btn btn-outline-dark" onclick="onclick_z()" style="width:40px;">Z</button>
                </div>
                <table style="border:1px;width:500px" id="data">
	            </table>
            </div>
        </div>
      <script type="text/javascript" src="js/word-index.js"></script>
    </body>
</html>



