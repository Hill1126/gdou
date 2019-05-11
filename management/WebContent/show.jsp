<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->
<html lang="en">

<!-- Head -->
<head>

<title></title>

<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="Multi Tabs Resume Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Meta-Tags -->

<!-- Custom-Style-Sheet -->
<link rel="stylesheet" href="css/show_style.css" type="text/css" media="all">
<!-- //Custom-Style-Sheet -->

<!-- Fonts -->
<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" type="text/css" media="all">
<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Montserrat:400,700"			   type="text/css" media="all">
<!-- //Fonts -->

<!-- Default-JavaScript --><script type="text/javascript" src="js/jquery.min.js"></script>

</head>
<!-- //Head -->



	<!-- Body -->
	<body>

		<h1>个人信息</h1>

		<div class="containerw3layouts-agileits">

			<div id="verticalTab" class="resp-vtabs w3-agile" style="display: block; width: 100%; margin: 0px;">

				<ul class="resp-tabs-list agileits-w3layouts">
					<li class="resp-tab-item"><span>简介</span></li>
					<li class="resp-tab-item"><span>学院</span></li>
					<li class="resp-tab-item agileinfo"><span>入学信息</span></li>
					<li class="resp-tab-item"><span>更多信息</span></li>
				</ul>

				<div class="resp-tabs-container">

					<div class="resp-tab-content">
						<div class="agileabout">
							<div class="agileabout-image w3-agileits">
								<img src="${student.simg }" alt="W3layouts">
							</div>
							<div class="agileabout-info">
								<ul>
									<li><div class="li1">名字</div><div class="li2">:</div><div class="li3">${student.sname }</div><div class="clearfix"></div></li>
									<li><div class="li1">学号</div><div class="li2">:</div><div class="li3">${student.ssno }</div><div class="clearfix w3-agileits"></div></li>
									<li><div class="li1">电话</div><div class="li2">:</div><div class="li3">${student.stel }</div><div class="clearfix"></div></li>
									<li><div class="li1">电子邮箱</div><div class="li2 agileinfo">:</div><div class="li3"><a class="mail" href="mailto:mail@example.com">${student.smali }</a></div><div class="clearfix"></div></li>
									<li><div class="li1 agileinfo">籍贯</div><div class="li2">:</div><div class="li3 w3-agileits">${student.saddress }</div><div class="clearfix wthree"></div></li>
								</ul>
							</div>
							<div class="clear"></div>
						</div>
					</div>

					<div class="resp-tab-content">
						<div class="work">
							<div class="work-info agileits-w3layouts">
								<h4>${student.sdept }</h4>
								<h5>物联网工程</h5>
								<p> xxxxxxxxxxxx</p>
							</div>
						</div>
					</div>

					<div class="resp-tab-content">
						<div class="work w3-agileits">
							<div class="work-info">
								<h4>${student.sentrance }</h4>
								<h5>入学时间</h5>
								<p>这或许是你人生中的一个重要时刻</p>
							</div>
							<div class="work-info agileinfo">
								<h4>${student.sgraduate }</h4>
								<h5>毕业时间</h5>
								<p>不负韶华，勇敢前行</p>
							</div>
						</div>
					</div>


					<div class="resp-tab-content">						
						<div class="agileabout-info aitsabout">
							<ul>
								<li><div class="li1">性别</div><div class="li2 wthree">:</div><div class="li3">${student.ssex }</div><div class="clearfix w3-agile"></div></li>
								<li><div class="li1 w3-agile">生日</div><div class="li2">:</div><div class="li3">${student.sbirthday }</div><div class="clearfix"></div></li>
								<li><div class="li1">电话</div><div class="li2 w3-agile">:</div><div class="li3">${student.stel }</div><div class="clearfix"></div></li>
								<li><div class="li1">邮件</div><div class="li2">:</div><div class="li3"><a class="mail" href="mailto:mail@example.com">${student.smali }</a></div><div class="clearfix agile"></div></li>
								<li><div class="li1">个人博客</div><div class="li2">:</div><div class="li3"><a href="">www.baidu.com</a></div><div class="clearfix"></div></li>
								<li><div class="li1 w3-agile">籍贯</div><div class="li2">:</div><div class="li3">${student.saddress }</div><div class="clearfix"></div></li>
							</ul>
						</div>
						<div class="clear"></div>
						<div class="social-icons w3layouts agileits">
						</div>
					</div>
					<div class="clear"></div>

				</div>
				<div class="clear w3-agile"></div>

			</div>

		</div>

		<div class="w3lsfooteragileits">
		</div>



		<!-- Necessary-JavaScript-Files-&-Links -->

			<!-- Tabs-JavaScript -->
				<script src="js/easyResponsiveTabs.js"></script>
				<script type="text/javascript">
					$(document).ready(function () {
						$('#horizontalTab').easyResponsiveTabs({
							type: 'default',
							width: 'auto',
							fit: true,
							closed: 'accordion',
							activate: function(event) {
								var $tab = $(this);
								var $info = $('#tabInfo');
								var $name = $('span', $info);
								$name.text($tab.text());
								$info.show();
							}
						});
						$('#verticalTab').easyResponsiveTabs({
							type: 'vertical',
							width: 'auto',
							fit: true
						});
					});
				</script>
			<!-- //Tabs-JavaScript -->


		<!-- //Necessary-JavaScript-Files-&-Links -->


	</body>
	<!-- //Body -->

</html>