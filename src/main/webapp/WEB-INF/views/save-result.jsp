<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save-Result</title>
</head>
<body>
성공
<ul>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
<a href="/mvc/members/new-form">접수화면</a>
<a href="/mvc/members">목록화면</a>
</body>
</html>