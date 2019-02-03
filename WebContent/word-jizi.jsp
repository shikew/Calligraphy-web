<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <title>王羲之-集字</title>
     <link rel="stylesheet" href="css/style.css" />
     <script src="https://cdn.bootcss.com/jquery/1.9.1/jquery.js"></script>
     <script src="js/bootstrap.bundle.min.js"></script>
     <style type="text/css">
     li img {
		 position: relative;
	     width: 100%;
	     top: 50%;/*li高度的一半*/
	     transform: translateY(-50%); /*再向上移动自身的50%*/
     }
     .jizi-img{
	     list-style: none;
	     float: left;
	     width: 6.67%;/*15列图片排列*/
	     height: 100px;/*当图片尺寸不一的时候，设置一个高度*/
	     overflow: hidden;/*超出隐藏*/
     }
     </style>
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
                   集字
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
                <h1>王羲之-集字</h1>
                <h2>选择你想要查看的索引</h2>
            </div>
            <div class="content">
			    <form role="form">
					<div class="form-group" style="margin-top:80px;">
						<label for="name">输入简体·中文·汉字 || 支持整句输入</label>
						<textarea class="form-control" rows="3" id="jiziContent"></textarea>
					</div>
				</form>
				<div class="btn-toolbar" role="toolbar" style="margin-top:10px;">
				<div class="btn-group">
				    <button type="button" class="btn btn-outline-dark"> 行书</button>
				    <button type="button" class="btn btn-outline-dark"> 小楷</button>
				 </div>
				<div class="btn-group">
				    <button type="button" class="btn btn-outline-dark" id="biggerButton">
				    <span class="glyphicon glyphicon-zoom-in" style="color: rgb(255, 153, 51);"></span> 放大
				    </button>
				    <button type="button" class="btn btn-outline-dark" id="originalButton">
				    <span class="glyphicon glyphicon-search" style="color: rgb(255, 153, 51);"></span> 原大
				    </button>
				    <button type="button" class="btn btn-outline-dark" id="smallerButton">
					<span class="glyphicon glyphicon-zoom-out" style="color: rgb(255, 153, 51);"></span> 缩小
					</button>
				</div>
				</div>
				<div class="btn-group" style="margin-top:10px;">
				    <button type="button" class="btn btn-outline-dark" id="jiziButton">
				    <span class="glyphicon glyphicon-play" style="color: rgb(255, 153, 51);"></span> 生成集字
				    </button>
				    <button type="button" class="btn btn-outline-dark" id="randomButton">
				    <span class="glyphicon glyphicon-heart-empty" style="color: rgb(255, 153, 51);"></span> 随机诗词</button>
				</div>
				<div id="jizi-result" style= "height:100px;width:1000px">
					<ul id="image">
			        </ul>
				</div>
            </div>
        </div>
        <script type="text/javascript" src="js/word-jizi.js"></script>
</body>
</html>