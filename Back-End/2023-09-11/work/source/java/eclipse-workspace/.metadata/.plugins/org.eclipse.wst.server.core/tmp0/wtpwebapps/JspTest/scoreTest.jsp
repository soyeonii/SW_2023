<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    int score = Integer.parseInt(request.getParameter("score"));
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>점수 출력</title>
</head>
<body>
    <h1>시험 점수: <%=score %>점</h1>
    <%
        if (score >= 90) {
    %>
    <h1>A학점</h1>
    <%
        } else if (score >= 80 && score < 90) {
    %>
    <h1>B학점</h1>
    <%
        } else if (score >= 70 && score < 80) {
    %>
    <h1>C학점</h1>
    <%
        } else if (score >= 60 && score < 70) {
    %>
    <h1>D학점</h1>
    <%
        } else {
    %>
    <h1>F학점</h1>
    <%
        }
    %>
</body>
</html>