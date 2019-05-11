<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>学生信息管理系统</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
				 float:left; */
	
}

font {
	color: #666;
	font-size: 22px;
	font-weight: normal;
	padding-right: 17px;
}
</style>

<script>
 function check(obj){
  if(obj.id == 'student' && obj.checked == true){
  		 document.getElementById('root').checked = false;
  }
  else if(obj.id == 'root' && obj.checked == true){
   		document.getElementById('student').checked = false;
  }
 }
  </script>
  	<link rel="stylesheet" href="../management/css/student.css">
</head>
<body>

    <!-- 状态栏 -->
	<div id="state">
		<div id="left_nav">
			<span>欢迎您！</span>
			<span>请登录</span>
		</div>
	</div>
	
		<!-- 底部 -->
	<div id="footer"></div>


	<script src="../js/2.js"></script>
	<div class="container"
		style="width: 100%; height:460px; background: #fff url('images/loginbg.jpg') no-repeat;">
		<div class="row">
			<div class="col-md-7">
			</div>

			<div class="col-md-5">
				<div
					style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
					<font>用户登录</font>USER LOGIN
	
					<form class="form-horizontal" action="${pageContext.request.contextPath }/checkLogin" method="post">
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="username" name="username"
									placeholder="请输入用户名">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" id="inputPassword3" name="password"
									placeholder="请输入密码">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="inputPassword3" name="checkCode"
									placeholder="请输入验证码">
							</div>
							<div class="col-sm-3">
								<img 	onclick="this.src='${pageContext.request.contextPath}/checkImg?'+Math.random()" src="${pageContext.request.contextPath }/checkImg " />
							</div><br><br>
						<div style="color:red"> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<%=request.getAttribute("loginInfo")==null?"":request.getAttribute("loginInfo")%></div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label> <input type="checkbox" value="student" name="logintype" id="student" onclick = 'check(this)' checked="checked"> 学生
									</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
										type="checkbox" value="manage" name="logintype" id="root" onclick = 'check(this)'> 管理员
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" width="100" value="登录" name="submit"
									style="background: url('./images/login.gif') 
									no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>