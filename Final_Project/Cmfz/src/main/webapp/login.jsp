<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="this is my page"/>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>

    <link rel="icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="css/common.css" type="text/css"/>
    <link rel="stylesheet" href="css/login.css" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="themes/IconExtension.css"/>
    <script type="text/javascript" src="script/jquery.js"></script>
    <script type="text/javascript" src="script/common.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        //验证验证码
        function ckEnCode(obj) {
            var code = obj.value;
            var isOk = true;
            $.ajax({
                url: '${pageContext.request.contextPath}/kaptcha/kaptchaVerify',
                data: {"code": code},
                async: false,
                success: function (data) {
                    isOk = data;
                    if (data) {
                        $('#codeSpan').prop("style", "color:blue");
                        $('#codeSpan').text("验证码正确");
                    } else {
                        $('#codeSpan').prop("style", "color:red");
                        $('#codeSpan').text("验证码不正确");
                    }
                }
            });
            return isOk;
        }

        $(function () {
            //点击更换验证码：
            $("#captchaImage").click(function () {//点击更换验证码
                this.src = "${pageContext.request.contextPath}/kaptcha/defaultKaptcha?id=" + new Date().toString();
            });

            //验证码验证
            $('#enCode').blur(function () {
                ckEnCode(this);
            });

            //用户名验证
            $('#nameInput').validatebox({
                required: true,
                validType: 'verifyUsername',
                missingMessage: '请输入用户名'
            });
            //自定义用户名验证规则
            $.extend($.fn.validatebox.defaults.rules, {
                verifyUsername: {
                    validator: function (value, param) {
                        return value.length >= 2;
                    },
                    message: '用户名长度为2-20位'
                }
            });

            //密码验证
            $('#passwordInput').validatebox({
                required: true,
                validType: 'verifyPassword',
                missingMessage: '请输入密码'
            });
            //自定义密码验证规则
            $.extend($.fn.validatebox.defaults.rules, {
                verifyPassword: {
                    validator: function (value, param) {
                        return value.length >= 6;
                    },
                    message: '密码长度为6-20位'
                }
            });

            //form的easyui表单提交
            $('#loginForm').form({
                url: '${pageContext.request.contextPath}/admin/login',
                onSubmit: function () {
                    var isValid = $(this).form('validate');
                    var isCodeOK = ckEnCode($('#enCode').get(0));
                    return isValid && isCodeOK;
                },
                success: function (data) {
                    if (data == 'true') {
                        window.location.href = '${pageContext.request.contextPath}/main/main.jsp';
                    } else {
                        $('#codeSpan').prop("style", "color:red");
                        $('#codeSpan').text("用户名或密码不正确");
                    }
                }
            });


        });
	</script>
</head>
<body>

<div class="login">
    <form id="loginForm" method="post">

        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="img/header_logo.gif"/>
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input type="text" name="name" class="text" maxlength="20" id="nameInput"/>
                    <span id="nameSpan"></span>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input type="password" name="password" class="text" maxlength="20" id="passwordInput"
                           autocomplete="off"/>
                    <span id="passwordSpan"></span>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="code" class="text captcha" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" class="captchaImage"
                         src="${pageContext.request.contextPath}/kaptcha/defaultKaptcha" title="点击更换验证码"/>
                    <br/>
                    <span id="codeSpan"></span>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit"
                                                                                                        class="loginButton"
                                                                                                        value="登录">
                </td>
            </tr>
            </tbody>
        </table>
        <div class="powered">COPYRIGHT © 2008-2017.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>