<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>글 목록</title>
  </head>
  <body>
    <table align="center" border="1" width="80%">
      <thead>
        <tr height="10" align="center" bgcolor="lightgreen">
          <th>글 번호</th>
          <th>작성자</th>
          <th>제목</th>
          <th>작성일</th>
        </tr>
      </thead>
      <c:choose>
        <c:when test="${empty dataList}">
          <tbody>
            <tr height="10">
              <td colspan="4">
                <p align="center">
                  <b>
                    <span style="font-size: 9pt"> 등록된 글이 없습니다. </span>
                  </b>
                </p>
              </td>
            </tr>
          </tbody>
        </c:when>
        <c:otherwise></c:otherwise>
      </c:choose>
    </table>
  </body>
</html>
