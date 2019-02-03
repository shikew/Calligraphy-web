<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<script src="https://cdn.bootcss.com/jquery/1.9.1/jquery.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>书法馆</title>
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
	    <li class="nav-item active">
	      <a class="nav-link" href="welcome.jsp">首页</a>
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
		<div class="card-deck">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">重要通知</h5>
					<p class="card-text">This is a longer card with supporting text
						below as a natural lead-in to additional content. This content is
						a little bit longer.</p>
					<p class="card-text">
						<small class="text-muted">Last updated 3 mins ago</small>
					</p>
				</div>
			</div>


			<div class="card">
				<img class="card-img-top" src="images/wxz.jpg_" alt="王羲之">
				<div class="card-body">
					<h5 class="card-title">王羲之</h5>
					<p class="card-text">
						<small class="text-muted">东晋</small>
					</p>
					<div class="card-text">王羲之，字逸少，东晋时期著名书法家，有“书圣”之称。琅琊（今属山东临沂）人，后迁会
						稽山阴（今浙江绍兴），晚年隐居剡县金庭。历任秘书郞、宁远将军、江州刺史，后为会稽内史，领右将军。其书法兼善隶、草、楷、行各体，精
						研体势，心摹手追，广采众长，备精诸体，冶于一炉，摆脱了汉魏笔风，自成一家，影响深远。</div>
				</div>
				<div class="card-foot">

					<center>
						<div class="btn-group">
							<a type="button" class="btn btn-outline-dark"
								href="wxzjianjie.jsp">生平</a> <a type="button"
								class="btn btn-outline-dark" href="word-jizi.jsp">集字</a> <a type="button"
								class="btn btn-outline-dark" href="word-index.jsp">索引</a> <a type="button"
								class="btn btn-outline-dark" href="wxzbt.jsp">碑帖</a>
						</div>
					</center>

				</div>
			</div>

			<div class="card">
				<img class="card-img-top" src="images/zmf.jpg_" alt="赵孟頫">
				<div class="card-body">
					<h5 class="card-title">赵孟頫</h5>
					<p class="card-text">
						<small class="text-muted">元</small>
					</p>
					<div class="card-text">赵孟頫，字子昂，汉族，号松雪道人，又号水晶宫道人、鸥波，中年曾署孟俯。浙江吴兴（今
						浙江湖州）人。南宋末至元初著名书法家、画家、诗人，宋太祖赵匡胤十一世孙、秦王赵德芳嫡派子孙；其父赵与訔曾任南宋户部侍郎兼知临安府
						浙西安抚使。</div>
				</div>
				<div class="card-foot">

					<center>
						<div class="btn-group">
							<a type="button" class="btn btn-outline-dark"
								href="zmfjianjie.jsp">生平</a> <a type="button"
								class="btn btn-outline-dark" href="#">集字</a> <a type="button"
								class="btn btn-outline-dark" href="#">索引</a> <a type="button"
								class="btn btn-outline-dark" href="zmfbt.jsp">碑帖</a>
						</div>
					</center>

				</div>
			</div>

		</div>
		<br>
	</div>

</body>
</html>