<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
<script type="text/javascript">
    // 从 URL 中获取错误消息
    var errorMessage = '<%= request.getParameter("message") %>';
    // 如果错误消息不为空，则弹出窗口显示错误消息
    if (errorMessage !== null && errorMessage !== "") {
        alert(errorMessage);
    }
    // 跳转到登录页面
    window.location.href = "<%= request.getContextPath() %>/LoginPage/login.jsp";
</script>
</body>
</html>
