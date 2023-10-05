<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>${board.id}번 게시글</title>
</head>
<body>
제목: ${board.title}
작성자: ${board.nickname} <br/>
작성 시간: ${board.entryDate}
수정 시간: ${board.modifyDate} <br/>
내용: ${board.content}
<c:if test="${board.writerId eq logIn.id}">
    <a href="/board/update/${board.id}">수정하기</a>
    <a href="/board/delete/${board.id}">삭제하기</a>
</c:if> <br/>
<a href="/board/showAll">글 목록으로</a>
</body>
</html>
