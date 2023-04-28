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
<script type="text/javascript" src="background/resources/scripts/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="background/resources/scripts/pintuer.js"></script>
<title>新闻发布系统后台</title>
    <style>
        html {
            height: 100%;
        }
        body {
            margin:0;
            padding:0;
            font-family: sans-serif;
            background: linear-gradient(#141e30, #243b55);
        }

        .login-box {
            position: absolute;
            top: 50%;
            left: 50%;
            width: 400px;
            padding: 40px;
            transform: translate(-50%, -50%);
            background: rgba(0,0,0,.5);
            box-sizing: border-box;
            box-shadow: 0 15px 25px rgba(0,0,0,.6);
            border-radius: 10px;
        }

        .login-box h2 {
            margin: 0 0 30px;
            padding: 0;
            color: #fff;
            text-align: center;
        }

        .login-box .user-box {
            position: relative;
        }

        .login-box .user-box input {
            width: 100%;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            margin-bottom: 30px;
            border: none;
            border-bottom: 1px solid #fff;
            outline: none;
            background: transparent;
        }
        .login-box .user-box label {
            position: absolute;
            top:0;
            left: 0;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            pointer-events: none;
            transition: .5s;
        }

        .login-box .user-box input:focus ~ label,
        .login-box .user-box input:valid ~ label {
            top: -20px;
            left: 0;
            color: #03e9f4;
            font-size: 12px;
        }

        .login-box form a {
            position: relative;
            display: inline-block;
            padding: 10px 20px;
            color: #03e9f4;
            font-size: 16px;
            text-decoration: none;
            text-transform: uppercase;
            overflow: hidden;
            transition: .5s;
            margin-top: 40px;
            letter-spacing: 4px
        }

        .login-box a:hover {
            background: #03e9f4;
            color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 5px #03e9f4,
            0 0 25px #03e9f4,
            0 0 50px #03e9f4,
            0 0 100px #03e9f4;
        }

        .login-box a span {
            position: absolute;
            display: block;
        }

        .login-box a span:nth-child(1) {
            top: 0;
            left: -100%;
            width: 100%;
            height: 2px;
            background: linear-gradient(90deg, transparent, #03e9f4);
            animation: btn-anim1 1s linear infinite;
        }

        @keyframes btn-anim1 {
            0% {
                left: -100%;
            }
            50%,100% {
                left: 100%;
            }
        }

        .login-box a span:nth-child(2) {
            top: -100%;
            right: 0;
            width: 2px;
            height: 100%;
            background: linear-gradient(180deg, transparent, #03e9f4);
            animation: btn-anim2 1s linear infinite;
            animation-delay: .25s
        }

        @keyframes btn-anim2 {
            0% {
                top: -100%;
            }
            50%,100% {
                top: 100%;
            }
        }

        .login-box a span:nth-child(3) {
            bottom: 0;
            right: -100%;
            width: 100%;
            height: 2px;
            background: linear-gradient(270deg, transparent, #03e9f4);
            animation: btn-anim3 1s linear infinite;
            animation-delay: .5s
        }

        @keyframes btn-anim3 {
            0% {
                right: -100%;
            }
            50%,100% {
                right: 100%;
            }
        }

        .login-box a span:nth-child(4) {
            bottom: -100%;
            left: 0;
            width: 2px;
            height: 100%;
            background: linear-gradient(360deg, transparent, #03e9f4);
            animation: btn-anim4 1s linear infinite;
            animation-delay: .75s
        }

        @keyframes btn-anim4 {
            0% {
                bottom: -100%;
            }
            50%,100% {
                bottom: 100%;
            }
        }
    </style>
<script type="text/javascript">
    function focusNextInput(thisInput) {
        var inputs = document.getElementsByTagName("input");
        for(var i = 0;i<inputs.length;i++){
            // 如果是最后一个，则焦点回到第一个(如果想实现按顺序可以登陆，可以写入登陆方法)
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
            <input type="text" name="userName" required="" onkeydown="if(event.keyCode==13)focusNextInput(this);">
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
    ${error}
    <br>
    <font color="red">${msg}</font>
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