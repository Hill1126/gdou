<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<link href="css/change_style.css" rel='stylesheet' type='text/css' />

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<!--webfonts-->
<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,700,800' rel='stylesheet' type='text/css'>
<!--//webfonts-->

<script>
function validate() {
    var pwd1 = document.getElementById("new_password").value;
    var pwd2 = document.getElementById("new_password2").value;
 
<!-- 对比两次输入的密码 -->
    if(pwd1 == pwd2)
     {
        document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
        document.getElementById("button").disabled = false;
     }
else {
        document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
        document.getElementById("button").disabled = true;
     }
}
</script>
</head>
<body>
	
	<div class="login-07">
		<div class="seventh-login">
			<h3>修改密码</h3>
			<form class="seven" action="${pageContext.request.contextPath }/updatePassword" method="POST">
				<ul>
					<li>
						<input type="password"  name="old" id="old_password" placeholder="旧密码" required/>
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="password"  id="new_password" placeholder="新密码" required/>
						<div class="clear"> </div>
					</li>
					<li>
						<input type="password"  name="new" id="new_password2" placeholder="新密码" onkeyup="validate()"required/>
						<div class="clear"> </div>
					</li>
					<span id="tishi"></span>
					<input type="submit" value="确认修改" > 
				</ul>
			</form>
			
		</div>
	</div>
	

	<!--//End-login-form-->

		 		
</body>
</html>