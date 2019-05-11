<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.domain.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Personal Profile Form Widget Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<!-- //for-mobile-apps -->
<link href='//fonts.googleapis.com/css?family=Questrial' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/j-forms.css">
<link href="css/domain_style.css" rel="stylesheet" type="text/css" media="all" />

<style>
	    input[type=date]::-webkit-inner-spin-button { visibility: hidden; }
	    ::-webkit-datetime-edit { padding: 2px; } 
		::-webkit-datetime-edit-fields-wrapper { background-color: #eee; } 
		::-webkit-datetime-edit-text { color: #4D90FE; padding: 0 .3em; } 
		::-webkit-datetime-edit-year-field { color: purple; } 
		::-webkit-datetime-edit-month-field { color: blue; } 
		::-webkit-datetime-edit-day-field { color: green; } 
		::-webkit-inner-spin-button { visibility: hidden; } 
		::-webkit-calendar-picker-indicator { 
		border: 1px solid #ccc; 
		border-radius: 2px; 
		box-shadow: inset 0 1px #fff, 0 1px #eee; 
		background-color: #eee; 
		background-image: -webkit-linear-gradient(top, #f0f0f0, #e6e6e6); 
		color: #666; 
}
</style>
</head>
<body>



<div class="content">
		<h1>Personal Profile form widget</h1>
		<div class="main w3l">
			<div class="im-g">
				<img src="${student.simg }" alt="头像">
			</div>
			<form class="contact-forms wthree" action="${pageContext.request.contextPath }/updateStudent?Ssno=${student.ssno }" 
			method="post" accept-charset="UTF-8">
				<!-- end /.header-->

					<!-- start name -->
					<div class="first-line agileits">
						<div class="span6 main-row">
							<div class="input">
								
								<input type="text" id="Sname" name="Sname" value="${student.sname }" required>
								<span class="tooltip tooltip-right-top">你的名字</span>
							</div>
						</div>
						<div class="span6 main-row">
							<div class="input">
								
								<input type="text" id="Ssno" name="Ssno" value="${student.ssno }" required >
								
								
							</div>
						</div>
					</div>
					<!-- end name -->

					<!-- start email phone -->
					<div class="first-line agileits">
						<div class="span6 main-row">
							<div class="input">
								
								<input type="email" value="${student.smali }" id="Smali" name="Smali" required>
								<span class="tooltip tooltip-right-top">你的邮箱</span>
							</div>
						</div>
						<div class="span6 main-row">
							<div class="input">
								
								<input type="text" value="${student.stel }" id="Stel" name="Stel" required>
								<span class="tooltip tooltip-right-top">你的号码</span>
							</div>
						</div>
					</div>
				<div class="main-row">
						<label class="input select">
							<select name="Ssex" required>
								<option value="" selected disabled>性别</option>
								<option value="男">男</option>
								<option value="女"> 女</option>
							</select>
							<i></i>
						</label>
					</div>

					<!-- start Sdept -->
					<div class="main-row">
						<label class="input select">
							<select name="Sdept" required>
								<option value="" selected disabled>学院</option>
								<!-- jsp foreach 循环 -->
								<c:forEach items="${deptCategory}" var="dept">
								<option value="${dept.dname }">${dept.dname }</option>
								</c:forEach>		
							
							</select>
							<i></i>
						</label>
					</div>
					<!-- end Sdept -->
					<!-- start city Sbirthday code -->
					<div class="first-line agileits">
						<div class="span8 main-row">
							<div class="input">
								
								<input type="date" id="Sbirthday" value="${student.sbirthday }" name="Sbirthday" required>
										<span class="tooltip tooltip-left-top">你的生日</span>
								<input type="date" id="Sentrance" value="${student.sentrance }" name="Sentrance" required>
										<span class="tooltip tooltip-right-top">你的入学时间</span>
								<input type="date" id="Sgraduate" value="${student.sgraduate }" name="Sgraduate" required>
										<span class="tooltip tooltip-right-top">你的毕业时间</span>
							</div>
						</div>
					
					</div>
					<!-- end city Sbirthday code -->

					<!-- start address -->
					<div class="main-row">
						<div class="input">
							
							<input type="text" id="Saddress" value="${student.saddress }" name="Saddress" required>
									<span class="tooltip tooltip-right-top">你的籍贯</span>
						</div>
					</div>
					<!-- end address -->


					

					<!-- start Sdescribe -->
					<div class="main-row">
						<div class="input">
							<textarea spellcheck="false" name="Sdescribe">${student.sdescribe }</textarea>
								<span class="tooltip tooltip-right-top">你的描述</span>
						</div>
					</div>
					<!-- end Sdescribe -->

			
				<!-- end /.content -->

				<div class="footer">
					<button type="submit" class="primary-btn" value="确定">确定</button>
					<button type="reset" class="secondary-btn" value="重置">重置</button>
				</div>
				<!-- end /.footer -->

			</form>
		</div>
</div>
		<!-- Scripts -->
		<script src="js/jquery.1.11.1.min.js"></script>

		<!--[if lt IE 10]>
				<script src="j-folder/js/jquery.placeholder.min.js"></script>
			<![endif]-->

		<script>
			$(document).ready(function(){

				// Phone masking
				$('#phone').mask('(999) 999-9999', {placeholder:'x'});

				// Post code masking
				$('#post').mask('999-9999', {placeholder:'x'});

			});
		</script>
</body>
</html>
