<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>인덱스</title>
</head>
<body>
<form action="/auth" method="post">
    ID: <input type="text" name="username"/>
    PW: <input type="password" name="password"/>
    <button type="submit">로그인</button>
</form>
</body>
</html>