<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <title>글쓰기</title>
</head>
<body>
<form action="/board/write" method="post">
    제목 : <input type="text" name="title"><br/>
    내용 : <textarea name="content"></textarea><br/>
    <button type="submit">작성하기</button>
</form>
<a href="/board/showAll">목록으로</a>
</body>
</html>