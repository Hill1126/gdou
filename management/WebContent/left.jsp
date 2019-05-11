<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        <title></title>
        <style type="text/css">
            body{margin:0;padding:0;overflow-x:hidden;}
            html, body{height:100%;}
            img{border:none;}
            *{font-family:'微软雅黑';font-size:12px;color:#626262;}
            dl,dt,dd{display:block;margin:0;}
            a{text-decoration:none;}
            #bg{background-image:url(images/content/dotted.png);}
            .container{width:100%;height:100%;margin:auto;}

            /*left*/
            .menus_area{width:160px;height:auto !important;overflow:visible !important;position:fixed;height:100% !important;background-color:#3992d0;}
            .line{height:2px;width:100%;background-image:url(images/left/line_bg.png);background-repeat:repeat-x;}
            .menus_area dt{padding-left:40px;padding-right:10px;background-repeat:no-repeat;background-position:10px center;background-color: #3992d0;color:#f5f5f5;font-size:14px;position:relative;line-height:48px;cursor:pointer;}
            .menus_area dd{background-color:#317eb4;padding-left:40px;display: none}
            .menus_area dd a{color:#f5f5f5;line-height:20px;}
            .menus_area dt img{position:absolute;right:10px;top:20px;}
            .system_log dt{background-image:url(images/left/system.png)}
            .custom dt{background-image:url(images/left/custom.png)}
            .channel dt{background-image:url(images/left/channel.png)}
            .app dt{background-image:url(images/left/app.png)}
            .cloud dt{background-image:url(images/left/cloud.png)}
            .syetem_management dt{background-image:url(images/left/syetem_management.png)}
            .source dt{background-image:url(images/left/source.png)}
            .statistics dt{background-image:url(images/left/statistics.png)}
            .menus_area dl dd:last-child{padding-bottom:10px;}
            dt.on{background-color: #317eb4}
        </style>

    </head>
    <body id="bg">

        <div class="container">
            <div class="menus_area" id="menus_area">
                <div class="line"></div>
                <dl class="system_log">
                    <dt>个人信息<img src="images/left/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="${pageContext.request.contextPath }/studentCheck" target="mainFrame">查看个人信息</a></dd>
                    <dd><a href="${pageContext.request.contextPath }/getCategory" target="mainFrame">修改信息</a></dd>
                </dl>

                <dl class="custom">
                    <dt>完善信息<img src="images/left/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="${pageContext.request.contextPath }/addPho.jsp" target="mainFrame">添加头像</a></dd>
                </dl>

                <dl class="channel">
                    <dt>安全管理<img src="images/left/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="${pageContext.request.contextPath }/change.jsp" target="mainFrame">修改密码</a></dd>
                </dl>

                <dl class="app">
                    <dt>成绩管理<img src="images/left/select_xl01.png"></dt>
                    <dd class="first_dd"><a href="${pageContext.request.contextPath}/shutter.html" target="mainFrame">功能未实现</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/shutter.html" target="mainFrame">敬请期待</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/shutter.html" target="mainFrame">敬请期待</a></dd>
                </dl>

            </div>
        </div>

        <script type="text/javascript" src="js/jquery.js"></script> 
        <script type="text/javascript">

            $(function() {
                $("#menus_area").find("dt").click(function() { //一级菜单点击
                    if (!$(this).hasClass("on")) { //当前一级菜单不选中状态才切换
                        $("#menus_area").find("dt").removeClass("on");//所有的一级菜单去除选中样式
                        $(this).addClass("on");//当前一级菜单去除选中样式
                        $('dd').slideUp();//所有二级菜单隐藏
                        $(this).nextAll('dd').slideToggle();//当前所有二级菜单切换
                    }
                });
            })
        </script>
		<div style="text-align:center;">
</div>
    </body>
</html>