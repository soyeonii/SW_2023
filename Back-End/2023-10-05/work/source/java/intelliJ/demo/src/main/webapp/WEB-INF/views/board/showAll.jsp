<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
</head>
<body>
<a href="/board/write">글쓰기</a><br/>
<c:forEach items="${list}" var="board">
    ${board.id} /
    <a href="/board/showOne/${board.id}">${board.title}</a> /
    ${board.writerId} /
    ${board.entryDate} /
    ${board.modifyDate}
    <br/>
</c:forEach>
</body>
</html>