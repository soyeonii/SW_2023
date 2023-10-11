<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>글쓰기</title>
</head>
<body>
<h1>글쓰기</h1>
<form action="/board/write" method="post">
    제목: <input type="text" name="title"/>
    내용: <textarea name="content"></textarea>
    <button type="submit">글 쓰기</button>
</form>
</body>
</html>