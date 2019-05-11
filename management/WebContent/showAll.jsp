<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>	</title>
	<link rel="stylesheet" href="../management/css/2.css">
	<link rel="stylesheet" href="../management/css/teacher.css">
<style type="text/css">
	select {
	   border: 1px solid #555;
	   padding: 0.5em;
	   font-size: 11px;
	   line-height: 1.2em;
	   background: #fff;
	   -webkit-appearance: none;
	   -webkit-box-shadow: 1px 1px 1px #fff;
	   -webkit-border-radius: 0.5em;
	 }
    #box{
        width: 30px;
        margin: 30px auto;
        font-family: 'Microsoft YaHei';
        font-size: 14px;
    }
    #search{
        width: 78px;
        height: 32px;
        float: right;
        background: black;
        color: white;
        text-align: center;
        line-height: 32px;
        cursor: pointer;
    }
</style>

</head>
<body>
		
		<!-- 主体信息 -->
		<div id="main">
			<!-- 修改信息 -->
			<div  class="show" id="modify_show" >
		<form  action="${pageContext.request.contextPath }/findStudentByCondition" method="POST">
			
				<input style="width:150px; height:30px;"  type="text" name="name" placeholder="仅支持名字搜索">   
				&nbsp;&nbsp;&nbsp;<font size="3">学院</font> 
				<select style="width:120px;" name="dept">
					<option selected disabled value="">请选择</option>
				 	<c:forEach items="${deptList }" var="dept">
				 		<option value="${dept.dname }">${dept.dname }</option>
				 	</c:forEach>
				 </select>
				 &nbsp;&nbsp;&nbsp;
				 <font size="3">性别</font> 
				 <select style="width:70px;" name="sex">
				 	<option selected disabled value="">请选择</option>
				 	<option value="男">男</option>
				 	<option value="女">女</option>
				 </select>
				 <input style="width:50px; height:30px;" type="submit" value="搜索">
				 <br>
		</form>
			
			<h3>全部学生信息</h3>
			<c:forEach items="${stuList }" var="student">
			<div class="info-wrap">
             <img src="${student.simg }" alt="">
             <div>	
             	<table border="0" cellspacing="8">
					
					<tbody>
						
						<tr>
							<td><p>姓名：<span>${student.sname }</span></p></td>
							<td><p>性别：<span>${student.ssex }</span></p></td>
							<td><p >学号：<span class="num">${student.ssno }</span></p></td>
						</tr>
						<tr>
							<td><p>所属学院：<span>${student.sdept }</span></p></td>
							<td><p>出生日期：<span>${student.sbirthday }</span></p></td>
							<td><p>电话：<span>${student.stel }</span></p></td>
						</tr>
						<tr>
							<td><p>邮箱：<span>${student.smali }</span></p></td>
							<td><p>入学日期：<span>${student.sentrance }</span></p></td>
							<td><p>毕业日期：<span>${student.sgraduate }</span></p></td>
						</tr>
						<tr  >
							<td colspan="3"><p>家庭地址：<span>${student.saddress }</span></p></td>
							
						</tr>
						<tr>
							<td colspan="3">
							<p>个人描述：<span>${student.sdescribe }
							</span></p></td>
							
						</tr>
					</tbody>
					
				</table>
				<div class="btn_wrap">
				  
					<div class="delete btn" >
					<a href="${pageContext.request.contextPath }/deleteStudentById?manage_Sno=${student.ssno}" onclick="return confirm('请确认删除');"><button >删除</button></a></div>
					<div class="compile btn" >
					<a href="${pageContext.request.contextPath }/getCategory?manage_Sno=${student.ssno}" ><button >编辑</button></a></div>
				</div>

		
             </div>
			</div>
			</c:forEach>
		</div>
	</div>
	
			
			
		
	<!-- 确定删除弹出框 -->


	<script src="../management/js/2.js"></script>
	<script src="../management/js/teacher.js"></script>
	<script src="../management/js/jquery-3.3.1.min.js"></script>

</body>
</html>