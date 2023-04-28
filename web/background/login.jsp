<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--<link rel="stylesheet" href="background/resources/css/pintuer.css">--%>
<%--<link rel="stylesheet" href="background/resources/css/admin.css">--%>
<link rel="stylesheet" href="background/resources/css/login.css">
<script type="text/javascript" src="background/resources/scripts/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="background/resources/scripts/pintuer.js"></script>
<title>新闻发布系统后台</title>
<script type="text/javascript">
    function focusNextInput(thisInput) {
        var inputs = document.getElementsByTagName("input");
        for(var i = 0;i<inputs.length;i++){
            if(i==(inputs.length-1)){
                inputs[0].focus(); break;
            }else if(thisInput == inputs[i]){
                inputs[i+1].focus(); break;
            }
        }
    }
</script>
</head>
<body >
<div class="login-box">
    <h2>闪电新闻系统登录</h2>
    <form id='forms' name='login' action='user?action=login' method='post'>
        <div class="user-box">

            <input type="text" name="userName" required="" onkeydown="if(event.keyCode==13){focusNextInput(this);}">
            <label>账号</label>
        </div>
        <div class="user-box">
            <input type="password" name="password" required="" onkeydown="if(event.keyCode==13){document.login.submit();}">
            <label>密码</label>
        </div>

        <a href="javascript:document.getElementById('forms').reset();">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            重置
        </a>

        <a href="javascript:document.login.submit();">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            登录
        </a>
    </form>
<%--    注册功能待做--%>
<%--    <a href="" style="color:#03e9f4;">注册</a>--%>
<%--    ${error}--%>
    <br><br>
    <span style="color: red;font-size: 13px;">${usernameError}</span>
    <span style="color: red;font-size: 13px;">${passwordError}</span>
<%--    <font color="red">${msg}</font>--%>
</div>

<%--<div class="bg"></div>--%>
<%--<div class="container">--%>
<%--    <div class="line bouncein">--%>
<%--        <div class="xs6 xm4 xs3-move xm4-move">--%>
<%--            <div style="height:150px;"></div>--%>
<%--            <div class="media media-y margin-big-bottom">           --%>
<%--            </div>         --%>
<%--            <form action="user?action=login" method="post">--%>
<%--            --%>
<%--            <div class="panel loginbox">--%>
<%--                <div class="text-center margin-big padding-big-top"><h1>闪电新闻系统登录</h1></div>--%>
<%--                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="field field-icon-right">--%>
<%--                            <input type="text" class="input input-big" name="userName" placeholder="登录账号"  data-validate="required:请输入账号" />--%>
<%--                            <span class="icon icon-user margin-small"></span>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="field field-icon-right">--%>
<%--                            <input type="password" class="input input-big" name="password" placeholder="登录密码" data-validate="required:请填写密码" />--%>
<%--                            <span class="icon icon-key margin-small"></span>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div style="padding:0px 30px 30px 30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>--%>
<%--            </div>--%>
<%--            </form>  --%>
<%--             ${msg }        --%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
</body>
</html>